package com.cinema.repository;

import com.cinema.model.ScreeningRoom;
import com.cinema.model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeanceRepo extends JpaRepository<Seance, Long> {

    List<Seance> findAllByScreeningRoom(ScreeningRoom screeningRoom);
}
