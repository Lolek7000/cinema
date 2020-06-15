package com.cinema.repository;

import com.cinema.model.SeatPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatPriceRepo extends JpaRepository<SeatPrice, Long> {
}
