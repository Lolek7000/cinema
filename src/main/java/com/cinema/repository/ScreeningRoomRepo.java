package com.cinema.repository;

import com.cinema.model.Cinema;
import com.cinema.model.ScreeningRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScreeningRoomRepo extends JpaRepository<ScreeningRoom, Long> {

    Optional<ScreeningRoom> findByCinemaAndRoomNumber(Cinema cinema, int roomNumber);
}
