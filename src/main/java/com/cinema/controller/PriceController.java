package com.cinema.controller;

import com.cinema.exceptions.PriceNotFoundException;
import com.cinema.model.Price;
import com.cinema.repository.PriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("price")
public class PriceController {

    private PriceRepo priceRepo;

    @Autowired
    public PriceController(PriceRepo priceRepo) {
        this.priceRepo = priceRepo;
    }

    @PostMapping("add")
    public void addPrice(@RequestBody @Valid Price price){
        priceRepo.save(price);
    }

    @GetMapping("getAll")
    public List<Price> getAll(){
        return priceRepo.findAll();
    }

    @PutMapping("change")
    public void changePrice(@RequestBody @Valid Price price){
        if (price.getId() == null || !priceRepo.findById(price.getId()).isPresent()){
            throw new PriceNotFoundException(price.getId());
        }
        priceRepo.save(price);
    }
}
