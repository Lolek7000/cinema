package com.cinema.service;

import com.cinema.model.Seance;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface SeanceService {

    ResponseEntity addSeance(Seance seance);

    void deleteSeanceById(Long id);

    Optional<Seance> getSeanceById(Long id);

    List<Seance> getAllSeances();

    void updateSeance(Seance updatedSeance);
}
