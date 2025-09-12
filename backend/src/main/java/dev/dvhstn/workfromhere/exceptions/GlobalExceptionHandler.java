package dev.dvhstn.workfromhere.exceptions;

import dev.dvhstn.workfromhere.spaces.exception.SpaceResourceException;
import dev.dvhstn.workfromhere.users.exception.RoleResourceException;
import dev.dvhstn.workfromhere.users.exception.UserResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SpaceResourceException.class)
    public ResponseEntity<String> handleSpaceResourceNotFoundException(SpaceResourceException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(UserResourceException.class)
    public ResponseEntity<String> handleUserResourceNotFoundException(UserResourceException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(RoleResourceException.class)
    public ResponseEntity<String> handleRoleResourceNotFoundException(RoleResourceException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
}
