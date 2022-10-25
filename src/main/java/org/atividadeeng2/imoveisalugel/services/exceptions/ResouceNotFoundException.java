package org.atividadeeng2.imoveisalugel.services.exceptions;

public class ResouceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResouceNotFoundException(Object id){
        super("Resouce not found.ID" + id);
    }
}
