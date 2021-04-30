package com.belose.sangam.learning.spring.exception;

public class RoomNotFoundException extends Exception {

    private String errorMessage;

    public RoomNotFoundException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }
}
