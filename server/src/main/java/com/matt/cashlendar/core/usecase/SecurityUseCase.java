package com.matt.cashlendar.core.usecase;

import com.matt.cashlendar.configuration.exception.CashlendarException;
import com.matt.cashlendar.configuration.security.TokenService;
import com.matt.cashlendar.core.entity.ClientEntity;
import com.matt.cashlendar.core.gateway.SecurityGateway;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.nonNull;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SecurityUseCase {

    private SecurityGateway securityGateway;
    private PasswordEncoder passwordEncoder;
    private TokenService tokenService;

    @Transactional(readOnly = true)
    public ClientEntity findByEmail(String email) {
        return securityGateway.findByEmail(email);
    }

    @Transactional(readOnly = true)
    public String login(String username, String password) {
        ClientEntity clientEntity = this.findByEmail(username);

        if (passwordEncoder.matches(password, clientEntity.getPassword())) {
            return tokenService.generateToken(clientEntity);
        }

        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ClientEntity register(ClientEntity clientEntity) {
        if (nonNull(this.findByEmail(clientEntity.getEmail()))) throw new CashlendarException("User already exists!");

        clientEntity.setPassword(passwordEncoder.encode(clientEntity.getPassword()));

        return securityGateway.register(clientEntity);
    }

}
