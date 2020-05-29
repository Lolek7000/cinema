package com.cinema.service.impl;

import com.cinema.exceptions.CinemaNotFoundException;
import com.cinema.exceptions.ScreeningRoomNotFoundException;
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
    public Optional<ScreeningRoom> updateScreeningRoom(ScreeningRoom updatedScreeningRoom) {
        Optional<ScreeningRoom> screeningRoom = screeningRoomRepo.findById(updatedScreeningRoom.getId());
        if (screeningRoom.isPresent()) {
            screeningRoomRepo.save(updatedScreeningRoom);
        }
        return screeningRoom;
    }

    @Override
    public void deleteScreeningRoomById(Long screeningRoomId) {
        if (!screeningRoomRepo.findById(screeningRoomId).isPresent()) {
            throw new ScreeningRoomNotFoundException(screeningRoomId);
        }
        screeningRoomRepo.deleteById(screeningRoomId);
    }
}
