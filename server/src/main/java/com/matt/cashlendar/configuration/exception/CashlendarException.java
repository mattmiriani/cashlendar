package com.matt.cashlendar.configuration.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CashlendarException extends RuntimeException {
    private final HttpStatus httpStatus;

    public CashlendarException(String message) {
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public CashlendarException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
