package com.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer reservationNumber;

    @NotNull(message = "First name is mandatory.")
    @NotBlank(message = "First name is mandatory.")
    @NotEmpty(message = "First name is mandatory.")
    private String firstName;

    @NotNull(message = "Last name is mandatory.")
    @NotBlank(message = "Last name is mandatory.")
    @NotEmpty(message = "Last name is mandatory.")
    private String lastName;

    @Email
    private String email;

    @ManyToOne
    @NotNull(message = "Seance is mandatory.")
    private Seance seance;

    @ElementCollection
    private Set<Seat> seats;

}
