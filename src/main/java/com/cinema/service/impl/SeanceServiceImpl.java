package com.cinema.service.impl;

import com.cinema.exceptions.*;
import com.cinema.model.Movie;
import com.cinema.model.ScreeningRoom;
import com.cinema.model.Seance;
import com.cinema.repository.CinemaRepo;
import com.cinema.repository.MovieRepo;
import com.cinema.repository.ScreeningRoomRepo;
import com.cinema.repository.SeanceRepo;
import com.cinema.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeanceServiceImpl implements SeanceService {

    private SeanceRepo seanceRepo;
    private CinemaRepo cinemaRepo;
    private ScreeningRoomRepo screeningRoomRepo;
    private MovieRepo movieRepo;

    @Autowired
    public SeanceServiceImpl(SeanceRepo seanceRepo, CinemaRepo cinemaRepo, ScreeningRoomRepo screeningRoomRepo, MovieRepo movieRepo) {
        this.seanceRepo = seanceRepo;
        this.cinemaRepo = cinemaRepo;
        this.screeningRoomRepo = screeningRoomRepo;
        this.movieRepo = movieRepo;
    }

    @Override
    public void addSeance(Seance seance) {

        CheckIfSeanceIsValid(seance);
        seanceRepo.save(seance);
    }

    @Override
    public List<Seance> getAllSeances() {
        return seanceRepo.findAll();
    }

    @Override
    public Optional<Seance> getSeanceById(Long id) {
        return seanceRepo.findById(id);
    }

    @Override
    public void deleteSeanceById(Long id) {
        if (!seanceRepo.findById(id).isPresent()){
            throw new SeanceNotFoundException(id);
        }
        seanceRepo.deleteById(id);
    }

    private void CheckIfSeanceIsValid(Seance seance) {
        if (seance.getCinema().getId() == null || !cinemaRepo.findById(seance.getCinema().getId()).isPresent()) {
            throw new CinemaNotFoundException(seance.getCinema().getId());
        }
        if (seance.getMovie().getId() == null || !movieRepo.findById(seance.getMovie().getId()).isPresent()) {
            throw new MovieNotFoundException(seance.getMovie().getId());
        }
        if (seance.getScreeningRoom().getId() == null || !screeningRoomRepo.findById(seance.getScreeningRoom().getId()).isPresent()) {
            throw new ScreeningRoomNotFoundException(seance.getScreeningRoom().getId());
        }

        ScreeningRoom screeningRoom = screeningRoomRepo.getOne(seance.getScreeningRoom().getId());

        if (!screeningRoom.getCinema().getId().equals(seance.getCinema().getId())) {
            throw new ScreeningRoomDoesNotExistException(screeningRoom.getId(), seance.getCinema().getId());
        }

        Movie movie = movieRepo.getOne(seance.getMovie().getId());
        seance.setMovie(movie);

        if (seanceRepo.findByDateOfEndBetweenAndScreeningRoom(seance.getSeanceDate(), seance.calculateDateOfEnd(), seance.getScreeningRoom()).isPresent()
                || seanceRepo.findBySeanceDateBetweenAndScreeningRoom(seance.getSeanceDate(), seance.calculateDateOfEnd(), seance.getScreeningRoom()).isPresent()) {
            throw new ScreeningRoomAlreadyTakenException(seance.getScreeningRoom().getId(), seance.getSeanceDate());
        }
    }
}
