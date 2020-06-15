package com.cinema.exceptions;

public class ReservationNotFoundException extends ObjectNotFoundException {
    public ReservationNotFoundException(Integer reservationNumber) {
        super("Reservation with number (" + reservationNumber + ") not found.");
    }
}
