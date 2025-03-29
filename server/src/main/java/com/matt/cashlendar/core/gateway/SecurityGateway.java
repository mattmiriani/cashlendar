package com.matt.cashlendar.core.gateway;

import com.matt.cashlendar.core.entity.ClientEntity;

public interface SecurityGateway {
    ClientEntity findByEmail(String email);
    ClientEntity register(ClientEntity clientEntity);
}
