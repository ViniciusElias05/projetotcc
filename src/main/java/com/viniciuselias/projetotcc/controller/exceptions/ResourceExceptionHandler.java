package com.viniciuselias.projetotcc.controller.exceptions;

import com.viniciuselias.projetotcc.model.service.exceptions.DatabaseException;
import com.viniciuselias.projetotcc.model.service.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(ObjectNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(DatabaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBadRequestException(DatabaseException e) {
        return e.getMessage();
    }
}
