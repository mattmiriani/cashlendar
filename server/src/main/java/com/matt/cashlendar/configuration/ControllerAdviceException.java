package com.matt.cashlendar.configuration;

import com.matt.cashlendar.configuration.exception.DataBaseException;
import com.matt.cashlendar.configuration.exception.entity.ExceptionEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceException {

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<ExceptionEntity> notFound(DataBaseException e) {
        ExceptionEntity err = new ExceptionEntity(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }
}
