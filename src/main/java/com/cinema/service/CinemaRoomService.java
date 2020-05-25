package com.cinema.service;

import com.cinema.model.CinemaRoom;

public interface CinemaRoomService {

    boolean addCinemaRoom(CinemaRoom newCinemaRoom);

    boolean deleteCinemaRoom(Long cinemaRoomId);
}
