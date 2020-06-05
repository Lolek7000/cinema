package com.cinema.exceptions;

import java.time.LocalDateTime;

public class ScreeningRoomAlreadyTakenException extends RuntimeException {

    public ScreeningRoomAlreadyTakenException(Long screeningRoomId, LocalDateTime seanceDate) {
        super("Screening room with id (" + screeningRoomId + ") at " + seanceDate + " is already taken.");
    }
}
