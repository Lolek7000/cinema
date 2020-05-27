package com.cinema.repository;

import com.cinema.model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeanceRepo extends JpaRepository<Seance, Long> {
}
