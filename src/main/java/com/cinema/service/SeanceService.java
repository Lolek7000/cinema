package com.cinema.service;

import com.cinema.model.Seance;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface SeanceService {

    ResponseEntity addSeance(Seance seance);

    List<Seance> getAllSeances();

    Optional<Seance> getSeanceById(Long id);

    Optional<Seance> updateSeance(Seance updatedSeance);

    void deleteSeanceById(Long id);
}
