package com.cinema.service.impl;

import com.cinema.model.Calc;
import com.cinema.model.Reservation;
import com.cinema.repository.ReservationRepo;
import com.cinema.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    ReservationRepo reservationRepo;

    @Autowired
    public ReservationServiceImpl(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    @Override
    public void addReservation(Reservation reservation) {
        reservation.setReservationPrice(Calc.calcPrice(reservation.getTicketAmountList(),reservation.getSeanceType()));
        reservationRepo.save(reservation);
    }

    @Override
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepo.findById(id);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }

    @Override
    public void updateReservation(Reservation reservation) {
        reservationRepo.save(reservation);
    }

    @Override
    public void deleteReservationById(Long id) {
        reservationRepo.deleteById(id);
    }
}
