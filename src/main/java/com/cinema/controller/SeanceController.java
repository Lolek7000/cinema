package com.cinema.controller;

import com.cinema.model.Seance;
import com.cinema.service.SeanceService;
import com.cinema.service.impl.SeanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/seance")
public class SeanceController {
    private SeanceService seanceService;

    @Autowired
    public SeanceController(SeanceServiceImpl seanceService) {
        this.seanceService = seanceService;
    }

    @GetMapping("/get/{id}")
    public Optional<Seance> getSeanceById(@PathVariable Long id){
        return seanceService.getSeanceById(id);
    }

    @GetMapping("/getAll")
    public List<Seance> getAllSeances(){
        return seanceService.getAllSeances();
    }

    @PostMapping("/add")
    public ResponseEntity addSeance(@RequestBody Seance seance){
        return seanceService.addSeance(seance);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSeanceById(@PathVariable Long id){
        seanceService.deleteSeanceById(id);
    }

    @PutMapping("/update")
    public void updateSeance(@RequestBody Seance updatedSeance){
        seanceService.updateSeance(updatedSeance);
    }

}
