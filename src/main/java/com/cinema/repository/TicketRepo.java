package com.cinema.repository;

import com.cinema.model.Seance;
import com.cinema.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepo extends JpaRepository<Ticket, Long> {

    List<Ticket> findAllBySeance(Seance seance);
}
