package com.matt.cashlendar.core.gateway;

import com.matt.cashlendar.core.entity.ClientEntity;

public interface ClientGateway {
    ClientEntity createClient(ClientEntity clientEntity);
}
