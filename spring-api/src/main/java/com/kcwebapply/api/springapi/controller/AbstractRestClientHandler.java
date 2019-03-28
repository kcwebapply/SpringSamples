package com.kcwebapply.api.springapi.controller;

import com.kcwebapply.api.springapi.exception.AbstractException;
import com.kcwebapply.api.springapi.exception.BadRequestException;
import com.kcwebapply.api.springapi.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class AbstractRestClientHandler{

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BadRequestException.class)
    public ErrorResponse throwBadRequestException(BadRequestException exception){
        return generateError(exception);
    }

   protected ErrorResponse generateError(AbstractException exception){
        return new ErrorResponse(
                exception.getMessage(),
                exception.getLevel()
        );
   }



}
