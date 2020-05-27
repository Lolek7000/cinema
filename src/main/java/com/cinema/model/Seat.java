package com.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@Getter
public class Seat {

    private char rowCharacter;

    private int placeNumber;

    private boolean isOccupy = false;

    private boolean isPaid = false;

    public Seat(char rowCharacter, int placeNumber) {
        this.rowCharacter = rowCharacter;
        this.placeNumber = placeNumber;
    }
}
