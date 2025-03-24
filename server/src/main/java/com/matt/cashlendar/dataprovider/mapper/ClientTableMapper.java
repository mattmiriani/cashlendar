package com.matt.cashlendar.dataprovider.mapper;

import com.matt.cashlendar.core.entity.ClientEntity;
import com.matt.cashlendar.dataprovider.entity.ClientTable;

public class ClientTableMapper {

    public static ClientTable to(ClientEntity clientEntity) {
        return ClientTable.builder()
                .name(clientEntity.getName())
                .email(clientEntity.getEmail())
                .password(clientEntity.getPassword())
                .build();
    }

    public static ClientEntity from(ClientTable table) {
        return ClientEntity.builder()
                .name(table.getName())
                .email(table.getEmail())
                .password(table.getPassword())
                .build();
    }
}
