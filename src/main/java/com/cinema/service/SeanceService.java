package com.cinema.service;

import com.cinema.model.Seance;

import java.util.List;
import java.util.Optional;

public interface SeanceService {

    void addSeance(Seance seance);

    List<Seance> getAllSeances();

    Optional<Seance> getSeanceById(Long id);

    void deleteSeanceById(Long id);
}
