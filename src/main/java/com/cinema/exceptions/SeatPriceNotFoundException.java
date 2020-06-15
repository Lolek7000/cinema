package com.cinema.exceptions;

public class SeatPriceNotFoundException extends ObjectNotFoundException {

    public SeatPriceNotFoundException(Long id) {
        super("Seat price with id (" + id + ") not found.");
    }
}
