package com.cinema.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Seance implements Serializable {

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

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Seance type may not be null.")
    private  SeanceType seanceType;

    @NotNull(message = "Seance date may not be null.")
    @Future(message = "Seance date may not be from past.")
    private LocalDateTime seanceDate;

    private LocalDateTime dateOfEnd;

    @PostLoad
    private void postLoad(){
        dateOfEnd = seanceDate.plusMinutes(movie.getDuration() + DURATION_OF_ADS_BEFORE_SEANCE + TIME_FOR_CLEANING);
    }

    public LocalDateTime calculateDateOfEnd(){
        LocalDateTime date = seanceDate.plusMinutes(movie.getDuration() + DURATION_OF_ADS_BEFORE_SEANCE + TIME_FOR_CLEANING);
        return date;
    }
}
