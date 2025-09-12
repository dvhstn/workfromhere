package dev.dvhstn.workfromhere.users.exception;

public class RoleResourceException extends RuntimeException {

    public RoleResourceException(String message) {
        super(message);
    }

    public RoleResourceException(String message, Throwable cause) {
        super(message, cause);
    }
}
