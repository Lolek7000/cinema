package com.cinema.exceptions;

public class ObjectDoesNotExistException extends RuntimeException{

    public ObjectDoesNotExistException(String message) {
        super(message);
    }
}
