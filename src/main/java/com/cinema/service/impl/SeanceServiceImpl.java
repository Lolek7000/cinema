package com.cinema.service.impl;

import com.cinema.model.Seance;
import com.cinema.repository.SeanceRepo;
import com.cinema.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SeanceServiceImpl implements SeanceService {

    private SeanceRepo seanceRepo;

    @Autowired
    public SeanceServiceImpl(SeanceRepo seanceRepo) {
        this.seanceRepo = seanceRepo;
    }

    @Override
    public ResponseEntity addSeance(Seance seance) {
        if(seanceRepo.existsById(seance.getId())) return new ResponseEntity("Object with that id already exists", HttpStatus.BAD_REQUEST);

        if (!isGoodSeanceTime(seance)) return new ResponseEntity("Bad Seance Time", HttpStatus.BAD_REQUEST);

        seanceRepo.save(seance);
        return new ResponseEntity("OK",HttpStatus.OK);
    }

    @Override
    public void deleteSeanceById(Long id) {
        if(seanceRepo.existsById(id))
            seanceRepo.deleteById(id);
    }

    @Override
    public Optional<Seance> getSeanceById(Long id) {
        return seanceRepo.findById(id);
    }

    @Override
    public List<Seance> getAllSeances() {
        return seanceRepo.findAll();
    }

    @Override
    public void updateSeance(Seance updatedSeance) {
        if(seanceRepo.existsById(updatedSeance.getId()))
            seanceRepo.save(updatedSeance);
    }
    private boolean isGoodSeanceTime(Seance seance){

        List<Seance> list = seanceRepo.findAll();
        LocalDateTime start = seance.getSeanceDate();
        LocalDateTime end = seance.giveDateOfEnd();
        int tabSize = list.size();

        for(int i=0;i<tabSize;i++){

            LocalDateTime tabStart = list.get(i).getSeanceDate();
            LocalDateTime tabEnd = list.get(i).giveDateOfEnd();
            int roomNumber=list.get(i).getScreeningRoom().getRoomNumber();

            if(seance.getScreeningRoom().getRoomNumber()==roomNumber) {

                if (start.isBefore(tabStart) && end.isAfter(tabStart)) return false;

                else if (start.isBefore(tabEnd) && end.isAfter(tabEnd)) return false;

                else if (start.isBefore(tabStart) && end.isAfter(tabEnd)) return false;
            }
        }
        return true;
    }
}
