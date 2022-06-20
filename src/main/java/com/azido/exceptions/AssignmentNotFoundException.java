package com.azido.exceptions;

public class AssignmentNotFoundException extends RuntimeException{

    public AssignmentNotFoundException() {
        super();
    }

    public AssignmentNotFoundException(String message) {
        super(message);
    }

    public AssignmentNotFoundException(Throwable cause) {
        super(cause);
    }

    public AssignmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
