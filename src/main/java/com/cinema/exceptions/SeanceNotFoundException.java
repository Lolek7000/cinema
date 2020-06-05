package com.cinema.exceptions;

public class SeanceNotFoundException extends ObjectNotFoundException {

    public SeanceNotFoundException(Long id) {
        super("Seance with id (" + id + ") not found.");
    }
}
