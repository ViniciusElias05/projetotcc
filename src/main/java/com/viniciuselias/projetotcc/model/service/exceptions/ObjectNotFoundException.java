package com.viniciuselias.projetotcc.model.service.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ObjectNotFoundException(Long id) {
        super("Not found id: " + id);
    }

}
