package com.cinema.controller;

import com.cinema.model.ScreeningRoom;
import com.cinema.service.ScreeningRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/room")
public class ScreeningRoomController {

    private ScreeningRoomService screeningRoomService;

    public ScreeningRoomController(ScreeningRoomService screeningRoomService) {
        this.screeningRoomService = screeningRoomService;
    }

    @PostMapping("add")
    public void addCinemaRoom(@RequestBody @Valid ScreeningRoom newScreeningRoom) {
        screeningRoomService.addScreeningRoom(newScreeningRoom);
    }

    @GetMapping("getAll")
    public List<ScreeningRoom> getAllScreeningRooms() {
        return screeningRoomService.getAllScreeningRooms();
    }

    @GetMapping("get/{screeningRoomId}")
    public ResponseEntity<ScreeningRoom> getScreeningRoomById(@PathVariable Long screeningRoomId) {
        return ResponseEntity.of(screeningRoomService.getScreeningRoomById(screeningRoomId));
    }

    @PutMapping("update")
    public ResponseEntity<ScreeningRoom> updateScreeningRoom(@RequestBody @Valid ScreeningRoom updatedScreeningRoom) {
        return ResponseEntity.of(screeningRoomService.updateScreeningRoom(updatedScreeningRoom));
    }

    @DeleteMapping("delete/{screeningRoomId}")
    public void deleteScreeningRoomById(@PathVariable Long screeningRoomId) {
        screeningRoomService.deleteScreeningRoomById(screeningRoomId);
    }
}
