package com.matt.cashlendar.dataprovider;

import com.matt.cashlendar.core.entity.ClientEntity;
import com.matt.cashlendar.core.gateway.SecurityGateway;
import com.matt.cashlendar.dataprovider.mapper.ClientTableMapper;
import com.matt.cashlendar.dataprovider.repository.SecurityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SecurityDataProvider implements SecurityGateway {

    private SecurityRepository securityRepository;

    @Override
    public ClientEntity findByEmail(String email) {
        return ClientTableMapper.from(securityRepository.findByEmail(email));
    }

    @Override
    public ClientEntity register(ClientEntity clientEntity) {
        return ClientTableMapper.from(securityRepository.save(ClientTableMapper.to(clientEntity)));
    }
}
