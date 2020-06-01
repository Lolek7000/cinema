package com.cinema.exceptions;

public class CinemaAlreadyExistsException extends ObjectAlreadyExistsException {

    public CinemaAlreadyExistsException(String department) {
        super("Cinema department (" + department + ") already exists.");
    }
}
