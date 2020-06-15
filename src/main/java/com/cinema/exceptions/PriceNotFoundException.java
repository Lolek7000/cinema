package com.cinema.exceptions;

public class PriceNotFoundException extends ObjectNotFoundException {

    public PriceNotFoundException(Long id) {
        super("Price with id (" + id + ") not found.");
    }
}
