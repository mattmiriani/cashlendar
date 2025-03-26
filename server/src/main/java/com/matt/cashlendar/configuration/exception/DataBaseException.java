package com.matt.cashlendar.configuration.exception;

import java.io.Serial;

public class DataBaseException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public DataBaseException(){
        super();
    }

    public DataBaseException(String msg){
        super(msg);
    }

    public DataBaseException(String msg, Throwable cause){
        super(msg, cause);
    }
}
