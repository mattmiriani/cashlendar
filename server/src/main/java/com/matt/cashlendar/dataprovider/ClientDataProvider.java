package com.matt.cashlendar.dataprovider;

import com.matt.cashlendar.configuration.exception.DataBaseException;
import com.matt.cashlendar.core.entity.ClientEntity;
import com.matt.cashlendar.core.gateway.ClientGateway;
import com.matt.cashlendar.dataprovider.entity.ClientTable;
import com.matt.cashlendar.dataprovider.mapper.ClientTableMapper;
import com.matt.cashlendar.dataprovider.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientDataProvider implements ClientGateway {

    private ClientRepository clientRepository;

    @Override
    public ClientEntity createClient(ClientEntity clientEntity) {
        try {
            ClientTable table = ClientTableMapper.to(clientEntity);

            table = clientRepository.save(table);

            clientEntity = ClientTableMapper.from(table);

            return clientEntity;
        } catch(Exception e) {
            throw new DataBaseException("Error in client registration!", e);
        }
    }
}
