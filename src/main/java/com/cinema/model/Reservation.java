package com.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @NotNull(message = "seance cannot be null")
    private Seance seance;

    @NotNull(message = "email cannot be null")
    private String email;

    @NotNull(message = "ticketList cannot be null")
    private ArrayList<Ticket> ticketList;

    @NotNull(message = "ticketAmountList cannot be null")
    private ArrayList<TicketAmount> ticketAmountList;

    @NotNull(message = "seanceType cannot be null")
    private SeanceType seanceType;

    Double reservationPrice;
}
