package com.matt.cashlendar.core.gateway;

import com.matt.cashlendar.core.entity.ClientEntity;

import java.util.UUID;

public interface ClientGateway {
    ClientEntity create(ClientEntity clientEntity);
}
