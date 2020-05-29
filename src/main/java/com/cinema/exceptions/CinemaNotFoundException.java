package com.cinema.exceptions;

public class CinemaNotFoundException extends ObjectNotFoundException {

    public CinemaNotFoundException(Long id) {
        super("Cinema with id (" + id + ") not found.");
    }
}
