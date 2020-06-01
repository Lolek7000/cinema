package com.cinema.exceptions;

public class ScreeningRoomAlreadyExistsException extends ObjectAlreadyExistsException {

    public ScreeningRoomAlreadyExistsException(Long cinemaId, int roomNumber) {
        super("ScreeningRoom with number (" + roomNumber + ") already exists in cinema with id (" + cinemaId + ")");
    }
}
