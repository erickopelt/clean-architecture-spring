package io.opelt.cleanarchictecture.usecase.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(String id) {
        super(String.format("User with id %s not found", id));
    }
}
