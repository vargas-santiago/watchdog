package com.azido.exceptions;

public class SchoolNotFoundException extends RuntimeException {
    public SchoolNotFoundException() {
        super();
    }

    public SchoolNotFoundException(String message) {
        super(message);
    }

    public SchoolNotFoundException(Throwable cause) {
        super(cause);
    }

    public SchoolNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
