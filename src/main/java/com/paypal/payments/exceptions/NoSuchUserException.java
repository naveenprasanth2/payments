package com.paypal.payments.exceptions;

import java.io.Serial;

public class NoSuchUserException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public NoSuchUserException(String message) {
        super(message);
    }
}
