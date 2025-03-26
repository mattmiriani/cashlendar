package com.matt.cashlendar.core.usecase;

import com.matt.cashlendar.core.entity.ClientEntity;
import com.matt.cashlendar.core.gateway.ClientGateway;
import com.matt.cashlendar.core.usecase.config.UseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientUseCase implements UseCase<ClientEntity, UUID> {

    private ClientGateway clientGateway;

    @Override
    public Page<ClientEntity> findAll() {
        return null;
    }

    @Override
    public ClientEntity findById(UUID objectId) {
        return null;
    }

    @Override
    public ClientEntity create(ClientEntity object) {
        return clientGateway.create(object);
    }

    @Override
    public ClientEntity update(UUID objectId, ClientEntity object) {
        return null;
    }
}
