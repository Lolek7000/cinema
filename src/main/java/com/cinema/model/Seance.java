package com.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private CinemaRoom cinemaRoom;

    @ManyToOne
    private CinemaProgramme cinemaProgramme;

    @ManyToOne
    private Movie movie;

    private LocalDateTime dateOfSeance;

}
