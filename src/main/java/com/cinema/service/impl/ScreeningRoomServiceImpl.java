package com.cinema.service.impl;

import com.cinema.model.ScreeningRoom;
import com.cinema.repository.ScreeningRoomRepo;
import com.cinema.service.ScreeningRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreeningRoomServiceImpl implements ScreeningRoomService {

    private ScreeningRoomRepo screeningRoomRepo;

    @Autowired
    public ScreeningRoomServiceImpl(ScreeningRoomRepo screeningRoomRepo) {
        this.screeningRoomRepo = screeningRoomRepo;
    }

    @Override
    public boolean addCinemaRoom(ScreeningRoom newScreeningRoom) {
            screeningRoomRepo.save(newScreeningRoom);
            return true;
    }

    @Override
    public boolean deleteCinemaRoom(Long cinemaRoomId) {
        if (screeningRoomRepo.findById(cinemaRoomId).isPresent()) {
            screeningRoomRepo.deleteById(cinemaRoomId);
            return true;
        }
        return false;
    }
}
