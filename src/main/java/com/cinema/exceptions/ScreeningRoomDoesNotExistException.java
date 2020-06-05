package com.cinema.exceptions;

public class ScreeningRoomDoesNotExistException extends ObjectDoesNotExistException {

    public ScreeningRoomDoesNotExistException(Long screeningRoomId, Long cinemaId) {
        super("ScreeningRoom with id (" + screeningRoomId + ") does not exist in cinema with id (" + cinemaId + ")");
    }
}
