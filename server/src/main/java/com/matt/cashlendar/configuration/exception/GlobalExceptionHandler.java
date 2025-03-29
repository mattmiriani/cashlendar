package com.matt.cashlendar.configuration.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CashlendarException.class)
    public ResponseEntity<String> handleCashlendarException(CashlendarException ex) {
        return new ResponseEntity<>(ex.getMessage(), ex.getHttpStatus());
    }
}
