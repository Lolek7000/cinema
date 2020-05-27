package com.cinema.model;

import lombok.Getter;

@Getter
public class Seat {

    private char row;

    private int place;

    private boolean isOccupy = false;

    public Seat (char row, int place){
        this.row = row;
        this.place = place;
    }
}
