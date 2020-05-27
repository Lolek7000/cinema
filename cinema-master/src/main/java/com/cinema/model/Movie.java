package com.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Movie genre may not be null")
    @Enumerated(value = EnumType.STRING)
    private MovieGenre movieGenre;

    @Min(value = 1, message = "Lenght may not be less than 1.")
    @Max(value = 43200, message = "Lenght may not be greater than 43200.")
    private Integer length;

    @Size(max = 255, message = "Director is too long (max size is 255 characters).")
    @NotNull(message = "Director may not be null.")
    @NotBlank(message = "Director may not be blank.")
    private String director;

    @Size(max = 255, message = "Title is too long (max size is 255 characters).")
    @NotNull(message = "Title may not be null.")
    @NotBlank(message = "Title may not be blank.")
    private String title;

    @Lob
    @NotNull(message = "Description may not be null.")
    @NotBlank(message = "Description may not be blank.")
    private String description;

    @NotNull(message = "Release date may not be null.")
    private LocalDate releaseDate;

    @NotNull(message = "Others may not be null.")
    @NotBlank(message = "Others may not be blank.")
    private String others;

    @NotNull(message = "Source of poster may not be null.")
    @NotBlank(message = "Source of poster may not be blank.")
    private String posterSrc;

}
