package com.cinema.service.impl;

import com.cinema.exceptions.CinemaAlreadyExistsException;
import com.cinema.exceptions.CinemaNotFoundException;
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
    public void addCinema(Cinema newCinema) {
        if (!cinemaRepo.findByDepartment(newCinema.getDepartment()).isPresent()) {
            cinemaRepo.save(newCinema);
        } else {
            throw new CinemaAlreadyExistsException(newCinema.getDepartment());
        }
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
    public Cinema updateCinema(Cinema updatedCinema) {

        if (!cinemaRepo.findById(updatedCinema.getId()).isPresent()) {
            throw new CinemaNotFoundException(updatedCinema.getId());
        }
        if (cinemaRepo.findByDepartment(updatedCinema.getDepartment()).isPresent()) {
            throw new CinemaAlreadyExistsException(updatedCinema.getDepartment());
        }

        return cinemaRepo.save(updatedCinema);
    }

    @Override
    public void deleteCinema(Long cinemaId) {
        cinemaRepo.deleteById(cinemaId);
    }
}
