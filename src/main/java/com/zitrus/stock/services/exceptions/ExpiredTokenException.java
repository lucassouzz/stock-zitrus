package com.zitrus.stock.services.exceptions;

public class ExpiredTokenException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExpiredTokenException(String message) {
        super(message);
    }

}
