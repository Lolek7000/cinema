package com.cinema.service.impl;

import com.cinema.model.Cinema;
import com.cinema.model.Movie;
import com.cinema.repository.CinemaRepo;
import com.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaServiceImpl implements CinemaService {

    private CinemaRepo cinemaRepo;

    @Autowired
    public CinemaServiceImpl(CinemaRepo cinemaRepo) {
        this.cinemaRepo = cinemaRepo;
    }

    @Override
    public void addCinema(Cinema newCinema) {
            cinemaRepo.save(newCinema);
    }

    @Override
    public List<Cinema> getAllCinemas() {
        return cinemaRepo.findAll();
    }

    @Override
    public Optional<Cinema> getCinemaById(Long cinemaId) {
        return cinemaRepo.findById(cinemaId);
    }

    @Override
    public Optional<Cinema> updateCinema(Cinema updatedCinema) {
        Optional<Cinema> cinema = cinemaRepo.findById(updatedCinema.getId());
        if (cinemaRepo.findById(updatedCinema.getId()).isPresent()){
        }
        return cinema;
    }

    @Override
    public void deleteCinema(Long cinemaId) {
        cinemaRepo.deleteById(cinemaId);
    }
}
