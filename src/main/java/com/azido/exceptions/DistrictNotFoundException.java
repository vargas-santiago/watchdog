package com.azido.exceptions;

public class DistrictNotFoundException extends RuntimeException {

    public DistrictNotFoundException() {
        super();
    }

    public DistrictNotFoundException(String message) {
        super(message);
    }

    public DistrictNotFoundException(Throwable cause) {
        super(cause);
    }

    public DistrictNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
