package com.matt.cashlendar.entrypoint.mapper;

import com.matt.cashlendar.configuration.exception.CashlendarException;
import com.matt.cashlendar.core.entity.ClientEntity;
import com.matt.cashlendar.entrypoint.entity.ClientRequestHttpModel;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public class ClientRequestHttpModelMapper {

    public static ClientRequestHttpModel to(ClientEntity clientEntity) {
        return ClientRequestHttpModel.builder()
                .name(clientEntity.getName())
                .email(clientEntity.getEmail())
                .build();
    }

    public static ClientEntity from(ClientRequestHttpModel httpModel) {
        return Optional.ofNullable(httpModel).map(client ->
                ClientEntity.builder()
                        .name(client.getName())
                        .email(client.getEmail())
                        .build())
                .orElseThrow(() -> new CashlendarException("Client cannot be null", HttpStatus.BAD_REQUEST));
    }
}
