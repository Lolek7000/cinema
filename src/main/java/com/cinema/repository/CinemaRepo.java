package com.cinema.repository;

import com.cinema.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CinemaRepo extends JpaRepository<Cinema, Long> {

    Optional<Cinema> findByDepartment(String department);
}
