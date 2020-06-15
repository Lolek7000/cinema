package com.cinema.service.impl;

import com.cinema.exceptions.IncorrectAmountOfTicket;
import com.cinema.exceptions.ReservationNotFoundException;
import com.cinema.exceptions.SeanceNotFoundException;
import com.cinema.exceptions.SeatsDoesNotExistsException;
import com.cinema.model.*;
import com.cinema.repository.ReservationRepo;
import com.cinema.repository.SeanceRepo;
import com.cinema.repository.TicketRepo;
import com.cinema.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepo reservationRepo;
    private SeanceRepo seanceRepo;
    private TicketRepo ticketRepo;

    public ReservationServiceImpl(ReservationRepo reservationRepo, SeanceRepo seanceRepo, TicketRepo ticketRepo) {
        this.reservationRepo = reservationRepo;
        this.seanceRepo = seanceRepo;
        this.ticketRepo = ticketRepo;
    }

    @Autowired


    @Override
    public boolean makeReservation(Reservation newReservation) {

        if (newReservation.getSeance().getId() == null || !seanceRepo.findById(newReservation.getSeance().getId()).isPresent()) {
            throw new SeanceNotFoundException(newReservation.getSeance().getId());
        }
        Seance seance = seanceRepo.getOne(newReservation.getSeance().getId());

        ScreeningRoom screeningRoom = seance.getScreeningRoom();
        if (screeningRoom.getSeats().containsAll(newReservation.getSeats())) {
            List<Reservation> reservations = reservationRepo.findAllBySeance(seance);
            List<Ticket> tickets = ticketRepo.findAllBySeance(seance);
            if (checkIfSeatsAreAvailable(newReservation, reservations, tickets)) {
                reservationRepo.save(newReservation);
                return true;
            }
        } else {
            throw new SeatsDoesNotExistsException();
        }
        return false;
    }

    @Override
    public void confirmReservation(Integer reservationNumber, ArrayList<TicketType> ticketTypes) {
        if (reservationNumber == null && !reservationRepo.findByReservationNumber(reservationNumber).isPresent()) {
            throw new ReservationNotFoundException(reservationNumber);
        }

        Reservation reservation = reservationRepo.findByReservationNumber(reservationNumber).get();

        if (reservation.getSeats().size() != ticketTypes.size()) {
            throw new IncorrectAmountOfTicket(ticketTypes.size());
        }
        ArrayList<Seat> seats = (ArrayList<Seat>) reservation.getSeats();
        for (int i = 0; i < reservation.getSeats().size(); i++) {
            ticketRepo.save(new Ticket(reservation.getSeance(), ticketTypes.get(i), seats.get(i)));
        }
    }

    @Override
    public boolean cancelReservation(Integer reservationNumber) {
        Optional<Reservation> reservation = reservationRepo.findByReservationNumber(reservationNumber);
        if (reservation.isPresent()) {
            reservationRepo.delete(reservation.get());
            return true;
        } else {
            throw new ReservationNotFoundException(reservationNumber);
        }
    }

    private boolean checkIfSeatsAreAvailable(Reservation newReservation, List<Reservation> reservations, List<Ticket> tickets) {
        for (Reservation reservation : reservations) {
            for (Seat seat : reservation.getSeats()) {
                if (newReservation.getSeats().contains(seat)) {
                    return false;
                }
            }
        }
        for (Ticket ticket : tickets) {
            if (newReservation.getSeats().contains(ticket.getSeat())) {
                return false;
            }
        }
        return true;
    }
}
