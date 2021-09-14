package com.lucasmurilo.helpdesk.services.exception;

public class DateIntegrityViolationException extends RuntimeException{

    public DateIntegrityViolationException(String message) {
        super(message);
    }

    public DateIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
