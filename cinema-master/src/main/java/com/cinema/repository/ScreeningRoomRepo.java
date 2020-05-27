package com.cinema.repository;

import com.cinema.model.ScreeningRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRoomRepo extends JpaRepository<ScreeningRoom, Long> {
}
