package com.viniciuselias.projetotcc.model.service.exceptions;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(Long id) {
        super("Not found id: " + id);
    }

}
