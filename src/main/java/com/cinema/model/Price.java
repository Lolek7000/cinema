package com.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"seanceType", "ticketType"}))
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Seance type is mandatory.")
    private SeanceType seanceType;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Ticket type is mandatory.")
    private TicketType ticketType;

    @NotNull(message = "Price is mandatory.")
    public Double price;

}
