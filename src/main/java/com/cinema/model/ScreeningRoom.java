package com.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"roomNumber", "cinema_id"}))
public class ScreeningRoom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Cinema may not be null.")
    private Cinema cinema;

    @NotNull(message = "Room number may not be null")
    @Min(value = 1, message = "Room number may not be less than 1")
    private Integer roomNumber;

    @ElementCollection
    @NotNull(message = "Seats may not be null.")
    private Set<Seat> seats = new HashSet<>();

    public List<Seat> getSeats() {
        List<Seat> sortedList = new ArrayList<>(this.seats);
        Collections.sort(sortedList);
        return sortedList;
    }
}

