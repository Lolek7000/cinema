package com.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

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

    private static final int DURATION_OF_ADS_BEFORE_SEANCE = 20;

    private static final int TIME_FOR_CLEANING = 20;

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

    public LocalDateTime giveDateOfEnd() {
        LocalDateTime localDateTime = seanceDate;
        seanceDate.plusMinutes(movie.getLength() + DURATION_OF_ADS_BEFORE_SEANCE + TIME_FOR_CLEANING);
        return seanceDate;
    }

}
