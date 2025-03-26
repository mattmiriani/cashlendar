package com.matt.cashlendar.dataprovider.mapper;

import com.matt.cashlendar.core.entity.ClientEntity;
import com.matt.cashlendar.dataprovider.entity.ClientTable;
import com.matt.cashlendar.fixture.ClientFixture;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTableMapperTest {


    @Nested
    class To {
        @Test
        void to() {
            ClientEntity clientEntity = ClientFixture.createClientEntity(null);

            ClientTable result = ClientTableMapper.to(clientEntity);

            assertEquals(clientEntity.getName(), result.getName());
            assertEquals(clientEntity.getEmail(), result.getEmail());
            assertEquals(clientEntity.getPassword(), result.getPassword());
        }
    }

    @Nested
    class From {
        @Test
        void from() {
            ClientTable table = ClientFixture.createClientTable(null);

            ClientEntity result = ClientTableMapper.from(table);

            assertEquals(table.getName(), result.getName());
            assertEquals(table.getEmail(), result.getEmail());
            assertEquals(table.getPassword(), result.getPassword());
        }
    }
}