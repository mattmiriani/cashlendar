package com.matt.cashlendar.entrypoint.mapper;

import com.matt.cashlendar.configuration.exception.CashlendarException;
import com.matt.cashlendar.core.entity.ClientEntity;
import com.matt.cashlendar.entrypoint.entity.LoginRequestHttpModel;
import org.springframework.http.HttpStatus;

import static java.util.Optional.ofNullable;

public class LoginRequestHttpModelMapper {

    public static LoginRequestHttpModel to(ClientEntity clientEntity, String token) {
        return LoginRequestHttpModel.builder()
                .username(clientEntity.getEmail())
                .token(token)
                .build();
    }

    public static ClientEntity from(LoginRequestHttpModel loginRequestHttpModel) {
        return ofNullable(loginRequestHttpModel).map(client ->
                        ClientEntity.builder()
                                .name(client.getUsername())
                                .email(client.getUsername())
                                .build())
                .orElseThrow(() -> new CashlendarException("Client cannot be null", HttpStatus.BAD_REQUEST));
    }
}
