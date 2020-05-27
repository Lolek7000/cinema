package com.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class ScreeningRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Cinema may not be null.")
    private Cinema cinema;

    @NotNull(message = "Room number may not be null")
    @Min(value = 1, message = "Room number may not be less than 1")
    private Integer roomNumber;

    @NotNull(message = "Room rows may not be null")
    @Min(value = 4, message = "Room rows may not be less than 1")
    private Integer roomRows;

    @NotNull(message = "Room places may not be null")
    @Min(value = 4)
    private Integer numberOfSeats;

    @ElementCollection
    private List<Seat> seats = new ArrayList<>();

}

