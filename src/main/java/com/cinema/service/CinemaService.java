package com.cinema.service;

import com.cinema.model.Cinema;

import java.util.List;
import java.util.Optional;

public interface CinemaService {

    boolean addCinema(Cinema newCinema);

    boolean deleteCinema(Long cinemaId);

    List<Cinema> getAllCinemas();

    Optional<Cinema> getCinemaById(Long cinemaId);
}
