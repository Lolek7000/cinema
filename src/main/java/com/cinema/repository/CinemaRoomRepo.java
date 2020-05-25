package com.cinema.repository;

import com.cinema.model.CinemaRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRoomRepo extends JpaRepository<CinemaRoom, Long> {
}
