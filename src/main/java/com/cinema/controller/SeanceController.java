package com.cinema.controller;

import com.cinema.model.Seance;
import com.cinema.service.SeanceService;
import com.cinema.service.impl.SeanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/seance")
public class SeanceController {
    private SeanceService seanceService;

    @Autowired
    public SeanceController(SeanceServiceImpl seanceService) {
        this.seanceService = seanceService;
    }

    @PostMapping("/add")
    public void addSeance(@RequestBody @Valid Seance seance) {

        seanceService.addSeance(seance);
    }

    @GetMapping("/getAll")
    public List<Seance> getAllSeances() {
        return seanceService.getAllSeances();
    }

    @GetMapping("/get/{id}")
    public Optional<Seance> getSeanceById(@PathVariable Long id) {
        return seanceService.getSeanceById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSeanceById(@PathVariable Long id) {
        seanceService.deleteSeanceById(id);
    }

}
