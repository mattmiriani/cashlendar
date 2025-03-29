package com.matt.cashlendar.entrypoint.mapper;

import com.matt.cashlendar.core.entity.ClientEntity;
import com.matt.cashlendar.entrypoint.entity.RegisterRequestHttpModel;

public class RegisterRequestHttpModelMapper {

    public static RegisterRequestHttpModel to(ClientEntity clientEntity) {
        return RegisterRequestHttpModel.builder()
                .name(clientEntity.getName())
                .email(clientEntity.getEmail())
                .build();
    }

    public static ClientEntity from(RegisterRequestHttpModel httpModel) {
        return ClientEntity.builder()
                .name(httpModel.getName())
                .email(httpModel.getEmail())
                .password(httpModel.getPassword())
                .build();
    }
}
