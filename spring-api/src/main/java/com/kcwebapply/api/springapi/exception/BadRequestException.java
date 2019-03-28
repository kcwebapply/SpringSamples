package com.kcwebapply.api.springapi.exception;

public class BadRequestException extends AbstractException{


    public BadRequestException(String message, String level) {
        super(message, level);
    }
}
