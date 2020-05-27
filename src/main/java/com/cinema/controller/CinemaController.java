package com.cinema.controller;

import com.cinema.model.Cinema;
import com.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

    private CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @PostMapping("add")
    public void addCinema(@RequestBody Cinema newCinema) {
        cinemaService.addCinema(newCinema);
    }

    @GetMapping("getAll")
    public List<Cinema> getAllCinemas() {
        return cinemaService.getAllCinemas();
    }

    @GetMapping("get/{cinemaId}")
    public ResponseEntity<Cinema> getCinemaById(@PathVariable Long cinemaId) {
        return ResponseEntity.of(cinemaService.getCinemaById(cinemaId));
    }

    @PutMapping("update")
    public ResponseEntity<Cinema> updateCinema(@RequestBody Cinema updatedCinema){
        return ResponseEntity.of(cinemaService.updateCinema(updatedCinema));
    }

    @DeleteMapping("delete/{cinemaId}")
    public void deleteCinema(@PathVariable Long cinemaId) {
        cinemaService.deleteCinema(cinemaId);
    }
}
