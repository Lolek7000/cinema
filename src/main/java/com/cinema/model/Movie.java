package com.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private MovieGenre movieGenre;

    private Integer length;

    private String director;

    private String title;

    @Lob
    private String description;

    private String posterSrc;

}
