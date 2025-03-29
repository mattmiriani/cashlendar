package com.matt.cashlendar.configuration.security;

import com.matt.cashlendar.core.entity.ClientEntity;
import com.matt.cashlendar.core.gateway.SecurityGateway;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomUserDetailsService implements UserDetailsService {

    private SecurityGateway securityGateway;

    @Override
    public UserDetails loadUserByUsername(String username) {
        ClientEntity user = this.securityGateway.findByEmail(username);

        return User
                .builder()
                .username(user.getName())
                .password(user.getPassword())
                .build();
    }
}
