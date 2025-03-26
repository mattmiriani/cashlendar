package com.matt.cashlendar.fixture;

import com.matt.cashlendar.core.entity.ClientEntity;
import com.matt.cashlendar.dataprovider.entity.ClientTable;
import com.matt.cashlendar.entrypoint.entity.ClientRequestHttpModel;

import java.util.UUID;

import static java.util.Optional.ofNullable;

public class ClientFixture {

    public static ClientEntity createClientEntity(UUID clientId) {
        return ofNullable(clientId)
                .map(id -> ClientEntity.builder()
                        .id(id)
                        .name("John Doe")
                        .email("john.doe@example.com")
                        .password("password123")
                        .build())
                .orElseGet(() -> ClientEntity.builder()
                        .id(UUID.randomUUID())
                        .name("John Doe")
                        .email("john.doe@example.com")
                        .password("password123")
                        .build());
    }

    public static ClientTable createClientTable(UUID clientId) {
        return ofNullable(clientId)
                .map(id -> ClientTable.builder()
                        .id(id)
                        .name("John Doe")
                        .email("john.doe@example.com")
                        .password("password123")
                        .build())
                .orElseGet(() -> ClientTable.builder()
                        .id(UUID.randomUUID())
                        .name("John Doe")
                        .email("john.doe@example.com")
                        .password("password123")
                        .build());
    }

    public static ClientRequestHttpModel createClientRequestHttpModel() {
        return ClientRequestHttpModel.builder()
                        .name("John Doe")
                        .email("john.doe@example.com")
                        .password("password123")
                        .build();
    }
}
