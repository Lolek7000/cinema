package com.cinema.repository;

import com.cinema.model.Cinema;
import com.cinema.model.ScreeningRoom;
import com.cinema.model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SeanceRepo extends JpaRepository<Seance, Long> {

    List<Seance> findAllByScreeningRoom(ScreeningRoom screeningRoom);
    Optional<Seance> findBySeanceDateBetweenAndScreeningRoom(LocalDateTime start, LocalDateTime end, ScreeningRoom cinema);
    Optional<Seance> findByDateOfEndBetweenAndScreeningRoom(LocalDateTime start, LocalDateTime end, ScreeningRoom cinema);
}
