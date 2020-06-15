package com.cinema.exceptions;

public class SeatsDoesNotExistsException extends ObjectDoesNotExistException {

    public SeatsDoesNotExistsException() {
        super("Given seats does not exist in this screeningRoom.");
    }
}
