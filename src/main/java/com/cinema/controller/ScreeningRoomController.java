package com.cinema.controller;

import com.cinema.model.ScreeningRoom;
import com.cinema.service.ScreeningRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class ScreeningRoomController {

    private ScreeningRoomService screeningRoomService;

    public ScreeningRoomController(ScreeningRoomService screeningRoomService) {
        this.screeningRoomService = screeningRoomService;
    }

    @PostMapping("add")
    public ResponseEntity<Boolean> addCinemaRoom(ScreeningRoom newScreeningRoom) {
        return new ResponseEntity<>(screeningRoomService.addCinemaRoom(newScreeningRoom), HttpStatus.OK);
    }

    @GetMapping("delete")
    public ResponseEntity<Boolean> deleteCinema(Long cinemaRoomId) {
        return new ResponseEntity<>(screeningRoomService.deleteCinemaRoom(cinemaRoomId), HttpStatus.OK);
    }
}
