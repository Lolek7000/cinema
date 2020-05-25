package com.cinema.controller;

import com.cinema.model.Cinema;
import com.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public boolean addCinema(@RequestBody Cinema newCinema) {
        return cinemaService.addCinema(newCinema);
}

    @GetMapping("getAll")
    public List<Cinema> getAllCinemas() {
        return cinemaService.getAllCinemas();
    }
}
