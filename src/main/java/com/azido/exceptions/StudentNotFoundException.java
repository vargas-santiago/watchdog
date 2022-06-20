package com.azido.exceptions;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException() {
        super();
    }

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
