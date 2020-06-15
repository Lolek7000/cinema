package com.cinema.repository;

import com.cinema.model.Reservation;
import com.cinema.model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepo extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllBySeance(Seance seance);
    Optional<Reservation> findByReservationNumber(Integer reservationNumber);
}
