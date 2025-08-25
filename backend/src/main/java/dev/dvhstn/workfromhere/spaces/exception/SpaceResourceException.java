package dev.dvhstn.workfromhere.spaces.exception;

public class SpaceResourceException extends RuntimeException{

    public SpaceResourceException(String message) {
        super(message);
    }

    public SpaceResourceException(String message, Throwable cause) {
        super(message, cause);
    }
}
