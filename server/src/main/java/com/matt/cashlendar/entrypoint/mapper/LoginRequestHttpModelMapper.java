package com.matt.cashlendar.entrypoint.mapper;

import com.matt.cashlendar.core.entity.ClientEntity;
import com.matt.cashlendar.entrypoint.entity.LoginRequestHttpModel;

public class LoginRequestHttpModelMapper {

    public static LoginRequestHttpModel to(ClientEntity clientEntity, String token) {
        return LoginRequestHttpModel.builder()
                .username(clientEntity.getEmail())
                .token(token)
                .build();
    }

    public static ClientEntity from(LoginRequestHttpModel loginRequestHttpModel) {
        return ClientEntity.builder()
                .name(loginRequestHttpModel.getUsername())
                .email(loginRequestHttpModel.getUsername())
                .build();
    }
}
