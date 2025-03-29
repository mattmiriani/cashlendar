package com.matt.cashlendar.core.usecase.config;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface UseCase<OBJECT, ID> {

    @Transactional(readOnly = true)
    Page<OBJECT> findAll();

    @Transactional(readOnly = true)
    OBJECT findById(ID objectId);

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    OBJECT create(OBJECT object);

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    OBJECT update(ID objectId, OBJECT object);
}
