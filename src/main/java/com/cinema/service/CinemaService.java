package com.cinema.service;

import com.cinema.model.Cinema;

import java.util.List;
import java.util.Optional;

public interface CinemaService {

    void addCinema(Cinema newCinema);

    List<Cinema> getAllCinemas();

    Optional<Cinema> getCinemaById(Long cinemaId);

    Optional<Cinema> updateCinema(Cinema updatedCinema);

    void deleteCinema(Long cinemaId);
}
