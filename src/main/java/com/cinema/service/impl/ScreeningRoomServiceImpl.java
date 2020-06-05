package com.cinema.service.impl;

import com.cinema.exceptions.CinemaNotFoundException;
import com.cinema.exceptions.ScreeningRoomAlreadyExistsException;
import com.cinema.exceptions.ScreeningRoomNotFoundException;
import com.cinema.model.Cinema;
import com.cinema.model.ScreeningRoom;
import com.cinema.repository.CinemaRepo;
import com.cinema.repository.ScreeningRoomRepo;
import com.cinema.service.ScreeningRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreeningRoomServiceImpl implements ScreeningRoomService {

    private ScreeningRoomRepo screeningRoomRepo;
    private CinemaRepo cinemaRepo;

    @Autowired
    public ScreeningRoomServiceImpl(ScreeningRoomRepo screeningRoomRepo, CinemaRepo cinemaRepo) {
        this.screeningRoomRepo = screeningRoomRepo;
        this.cinemaRepo = cinemaRepo;
    }

    @Override
    public void addScreeningRoom(ScreeningRoom newScreeningRoom) {
        if (newScreeningRoom.getCinema().getId() == null || !cinemaRepo.findById(newScreeningRoom.getCinema().getId()).isPresent()) {
            throw new CinemaNotFoundException(newScreeningRoom.getCinema().getId());
        }
        if (screeningRoomRepo.findByCinemaAndRoomNumber(newScreeningRoom.getCinema(), newScreeningRoom.getRoomNumber()).isPresent()) {
            throw new ScreeningRoomAlreadyExistsException(newScreeningRoom.getCinema().getId(), newScreeningRoom.getRoomNumber());
        }
        screeningRoomRepo.save(newScreeningRoom);
    }

    public List<ScreeningRoom> getAllScreeningRooms() {
        return screeningRoomRepo.findAll();
    }

    @Override
    public Optional<ScreeningRoom> getScreeningRoomById(Long screeningRoomId) {
        return screeningRoomRepo.findById(screeningRoomId);
    }

    @Override
    public List<ScreeningRoom> getAllScreeningRoomByCinema(Long cinemaId) {
        Optional<Cinema> cinema = cinemaRepo.findById(cinemaId);
        if (cinema.isPresent()) {
            return screeningRoomRepo.findByCinema(cinema.get());
        }
        throw new CinemaNotFoundException(cinemaId);
    }

    @Override
    public ScreeningRoom updateScreeningRoom(ScreeningRoom updatedScreeningRoom) {
        if (!screeningRoomRepo.findById(updatedScreeningRoom.getId()).isPresent()) {
            throw new ScreeningRoomNotFoundException(updatedScreeningRoom.getId());
        }
        if (updatedScreeningRoom.getCinema().getId() == null || !cinemaRepo.findById(updatedScreeningRoom.getCinema().getId()).isPresent()) {
            throw new CinemaNotFoundException(updatedScreeningRoom.getCinema().getId());
        }
        if (screeningRoomRepo.findByCinemaAndRoomNumber(updatedScreeningRoom.getCinema(), updatedScreeningRoom.getRoomNumber()).isPresent()) {
            throw new ScreeningRoomAlreadyExistsException(updatedScreeningRoom.getCinema().getId(), updatedScreeningRoom.getRoomNumber());
        }
        return screeningRoomRepo.save(updatedScreeningRoom);
}

    @Override
    public void deleteScreeningRoomById(Long screeningRoomId) {
        if (!screeningRoomRepo.findById(screeningRoomId).isPresent()) {
            throw new ScreeningRoomNotFoundException(screeningRoomId);
        }
        screeningRoomRepo.deleteById(screeningRoomId);
    }
}
