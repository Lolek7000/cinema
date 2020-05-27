package com.cinema.service;

import com.cinema.model.ScreeningRoom;

public interface ScreeningRoomService {

    boolean addCinemaRoom(ScreeningRoom newScreeningRoom);

    boolean deleteCinemaRoom(Long cinemaRoomId);
}
