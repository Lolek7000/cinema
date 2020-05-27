package com.cinema.service.impl;

import com.cinema.model.CinemaRoom;
import com.cinema.repository.CinemaRoomRepo;
import com.cinema.service.CinemaRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaRoomServiceImpl implements CinemaRoomService {

    private CinemaRoomRepo cinemaRoomRepo;

    @Autowired
    public CinemaRoomServiceImpl(CinemaRoomRepo cinemaRoomRepo) {
        this.cinemaRoomRepo = cinemaRoomRepo;
    }

    @Override
    public boolean addCinemaRoom(CinemaRoom newCinemaRoom) {
            cinemaRoomRepo.save(newCinemaRoom);
            return true;
    }

    @Override
    public boolean deleteCinemaRoom(Long cinemaRoomId) {
        if (cinemaRoomRepo.findById(cinemaRoomId).isPresent()) {
            cinemaRoomRepo.deleteById(cinemaRoomId);
            return true;
        }
        return false;
    }
}
