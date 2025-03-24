package com.matt.cashlendar.core.usecase;

import com.matt.cashlendar.core.entity.ClientEntity;
import com.matt.cashlendar.core.gateway.ClientGateway;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientUseCase {

    private ClientGateway clientGateway;

    public ClientEntity createClient(ClientEntity clientEntity) {
        return clientGateway.createClient(clientEntity);
    }
}
