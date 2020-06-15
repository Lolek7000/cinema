package com.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Seance seance;

    private TicketType ticketType;

    private Seat seat;

    public Ticket(Seance seance, TicketType ticketType, Seat seat) {
        this.seance = seance;
        this.ticketType = ticketType;
        this.seat = seat;
    }
}
