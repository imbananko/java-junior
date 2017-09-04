package com.acme.edu.exceptions;

public class WriterException extends Exception {
    private Object logObject;

    public Object getLogObject() {
        return logObject;
    }

    public WriterException(String message, Object logObject) {
        super(message);
        this.logObject = logObject;
    }
}
