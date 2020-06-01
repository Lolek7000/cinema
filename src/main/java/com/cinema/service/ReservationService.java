package com.cinema.service;

import com.cinema.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    void addReservation(Reservation reservation);
    Optional<Reservation> getReservationById(Long id);
    List<Reservation> getAllReservations();
    void updateReservation(Reservation reservation);
    void deleteReservationById(Long id);
}
