package com.cinema.service;

import com.cinema.model.Cinema;
import com.cinema.model.ScreeningRoom;

import java.util.List;
import java.util.Optional;

public interface ScreeningRoomService {

    void addScreeningRoom(ScreeningRoom newScreeningRoom);

    List<ScreeningRoom> getAllScreeningRooms();

    Optional<ScreeningRoom> getScreeningRoomById(Long ScreeningRoomId);

    List<ScreeningRoom> getAllScreeningRoomByCinema(Long cinemaId);

    ScreeningRoom updateScreeningRoom(ScreeningRoom updatedScreeningRoom);

    void deleteScreeningRoomById(Long screeningRoomId);
}
