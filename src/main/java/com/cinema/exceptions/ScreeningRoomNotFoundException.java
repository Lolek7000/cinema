package com.cinema.exceptions;

public class ScreeningRoomNotFoundException extends ObjectNotFoundException {

    public ScreeningRoomNotFoundException(Long id) {
        super("Screening room with id (" + id + ") not found.");
    }
}
