package com.cinema.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Ticket {

    public Ticket(Seat seat) {
        this.seat = seat;
    }



    private Seat seat;
}
