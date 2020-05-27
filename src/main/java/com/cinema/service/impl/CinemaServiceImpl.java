package com.cinema.service.impl;

import com.cinema.model.Cinema;
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
    public boolean addCinema(Cinema newCinema) {
            cinemaRepo.save(newCinema);
            return true;
    }

    @Override
    public boolean deleteCinema(Long cinemaId) {
        return false;
    }

    @Override
    public List<Cinema> getAllCinemas() {
        return cinemaRepo.findAll();
    }

    @Override
    public Optional<Cinema> getCinemaById(Long cinemaId) {
        return cinemaRepo.findById(cinemaId);
    }
}
