package com.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Cinema may not be null.")
    private Cinema cinema;

    @ManyToOne
    @NotNull(message = "Screening room may not be null.")
    private ScreeningRoom screeningRoom;

    @ManyToOne
    @NotNull(message = "Movie may not be null.")
    private Movie movie;

    @ElementCollection
    private List<Seat> seats = new ArrayList<>();

    @NotNull(message = "Seance date may not be null.")
    @Future(message = "Seance date may not be from past.")
    private LocalDateTime seanceDate;

    public LocalDateTime giveDateOfEnd(){
        LocalDateTime localDateTime = seanceDate;
        seanceDate.plusMinutes(movie.getLength()+20+20);
        return seanceDate;
    }

}
