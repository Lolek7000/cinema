package com.cinema.controller;

import com.cinema.model.Reservation;
import com.cinema.service.ReservationService;
import com.cinema.service.impl.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("reservation")
public class ReservationController {

    ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationServiceImpl reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/add")
    public void addReservation(@RequestBody Reservation reservation){
        reservationService.addReservation(reservation);
    }

    @GetMapping("/get/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Long id){
        return reservationService.getReservationById(id);
    }
    @GetMapping("/getAll")
    public List<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }

    @PutMapping("/update")
    public void updateReservation(@RequestBody Reservation reservation){
        reservationService.addReservation(reservation);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReservationById(@PathVariable Long id){
        reservationService.deleteReservationById(id);
    }
}
