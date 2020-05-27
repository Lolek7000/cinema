package com.cinema.controller;

import com.cinema.model.CinemaRoom;
import com.cinema.service.CinemaRoomService;
import com.cinema.service.impl.CinemaRoomServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class CinemaRoomController {

    private CinemaRoomService cinemaRoomService;

    public CinemaRoomController(CinemaRoomService cinemaRoomService) {
        this.cinemaRoomService = cinemaRoomService;
    }

    @PostMapping("add")
    public ResponseEntity<Boolean> addCinemaRoom(CinemaRoom newCinemaRoom) {
        return new ResponseEntity<>(cinemaRoomService.addCinemaRoom(newCinemaRoom), HttpStatus.OK);
    }

    @GetMapping("delete")
    public ResponseEntity<Boolean> deleteCinema(Long cinemaRoomId) {
        return new ResponseEntity<>(cinemaRoomService.deleteCinemaRoom(cinemaRoomId), HttpStatus.OK);
    }
}
