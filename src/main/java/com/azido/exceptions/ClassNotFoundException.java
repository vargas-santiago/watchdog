package com.azido.exceptions;

public class ClassNotFoundException extends RuntimeException {

    public ClassNotFoundException() {
        super();
    }

    public ClassNotFoundException(String message) {
        super(message);
    }

    public ClassNotFoundException(Throwable cause) {
        super(cause);
    }

    public ClassNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
