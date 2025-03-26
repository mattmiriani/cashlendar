package com.matt.cashlendar.core.usecase.config;

import org.springframework.data.domain.Page;

public interface UseCase<OBJECT, ID> {
    Page<OBJECT> findAll();
    OBJECT findById(ID objectId);
    OBJECT create(OBJECT object);
    OBJECT update(ID objectId, OBJECT object);
}
