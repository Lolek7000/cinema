package com.cinema.controller;

import com.cinema.exceptions.SeatPriceNotFoundException;
import com.cinema.model.SeatPrice;
import com.cinema.repository.SeatPriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/seat/price")
public class SeatPriceController {

    private SeatPriceRepo seatPriceRepo;

    @Autowired
    public SeatPriceController(SeatPriceRepo seatPriceRepo) {
        this.seatPriceRepo = seatPriceRepo;
    }

    @PostMapping("add")
    public void addSeatPrice(@RequestBody @Valid SeatPrice seatPrice) {
        seatPriceRepo.save(seatPrice);
    }

    @GetMapping("getAll")
    public List<SeatPrice> getAll() {
        return seatPriceRepo.findAll();
    }

    @PutMapping("change")
    public void changePrice(@RequestBody @Valid SeatPrice seatPrice) {
        if (seatPrice.getId() == null || !seatPriceRepo.findById(seatPrice.getId()).isPresent()) {
            throw new SeatPriceNotFoundException(seatPrice.getId());
        }
        seatPriceRepo.save(seatPrice);
    }


}
