package com.cinema.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class TicketAmount {
    private TicketType ticketType;
    private int ticketAmount;
}
