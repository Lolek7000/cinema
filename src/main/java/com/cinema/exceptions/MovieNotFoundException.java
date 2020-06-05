package com.cinema.exceptions;

public class MovieNotFoundException extends ObjectNotFoundException {

    public MovieNotFoundException(Long id) {
        super("Movie with id (" + id + ") not found.");
    }
}
