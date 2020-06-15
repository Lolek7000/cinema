package com.cinema.service;

import com.cinema.model.Reservation;
import com.cinema.model.TicketType;

import java.util.ArrayList;

public interface ReservationService {

    boolean makeReservation(Reservation reservation);

    void confirmReservation(Integer reservationNumber, ArrayList<TicketType> ticketTypes);

    boolean cancelReservation(Integer reservationNumber);
}
