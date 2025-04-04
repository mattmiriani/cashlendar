package com.matt.cashlendar.entrypoint.mapper;

import com.matt.cashlendar.configuration.exception.CashlendarException;
import com.matt.cashlendar.core.entity.ClientEntity;
import com.matt.cashlendar.entrypoint.entity.ClientRequestHttpModel;
import com.matt.cashlendar.fixture.ClientFixture;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class ClientRequestHttpModelMapperTest {

    @Nested
    class To {
        @Test
        void to() {
            ClientEntity clientEntity = ClientFixture.createClientEntity(null);

            ClientRequestHttpModel result = ClientRequestHttpModelMapper.to(clientEntity);

            assertEquals(clientEntity.getName(), result.getName());
            assertEquals(clientEntity.getEmail(), result.getEmail());
        }
    }

    @Nested
    class From {
        @Test
        void from() {
            ClientRequestHttpModel clientRequestHttpModel = ClientFixture.createClientRequestHttpModel();

            ClientEntity result = ClientRequestHttpModelMapper.from(clientRequestHttpModel);

            assertEquals(clientRequestHttpModel.getName(), result.getName());
            assertEquals(clientRequestHttpModel.getEmail(), result.getEmail());
        }

        @Test
        void fromException() {
            CashlendarException exception = assertThrows(
                    CashlendarException.class,
                    () -> ClientRequestHttpModelMapper.from(null)
            );

            assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
            assertEquals("Client cannot be null", exception.getMessage());
        }
    }
}