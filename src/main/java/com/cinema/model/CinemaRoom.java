package com.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class CinemaRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;

    private Integer rows;

    private Integer columns;

    @Lob
    private List<Seat> seats = new ArrayList<>();

    public CinemaRoom(Integer number, Integer rows, Integer columns){
        this.number = number;
        this.rows = rows;
        this.columns = columns;
        this.seats = setSeats(rows, columns);
    }

    private ArrayList<Seat> setSeats(Integer rows, Integer columns){
        ArrayList<Seat> seats = new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                seats.add(new Seat((char)(i+65),j+1));
            }
        }
        return seats;

    }



}
