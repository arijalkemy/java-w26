package org.ejercicio.deportistas.controller;

import org.ejercicio.deportistas.model.Sport;
import org.ejercicio.deportistas.model.Sporty;
import org.ejercicio.deportistas.model.dto.SportyDTO;
import org.ejercicio.deportistas.service.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class SportController {

    @Qualifier("sport")
    @Autowired
    private IRepository<Sport> sportRepository;

    @Qualifier("sporty")
    @Autowired
    private IRepository<SportyDTO> sportyRepository;

    @GetMapping("findSports")
    public ResponseEntity<List<Sport>> findSports() {
        List<Sport> sports = sportRepository.findAll();
        if (sports.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(sports, HttpStatus.OK);
    }

    @GetMapping("findSport/{name}")
    public ResponseEntity<Sport> findSport(@PathVariable String name) {
        Sport sport = sportRepository.findByName(name);
        if (sport == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(sport, HttpStatus.OK);
    }

    @GetMapping("findSportsPersons")
    public ResponseEntity<List<SportyDTO>> findSportsPersons() {
        List<SportyDTO> sportyDTOS = sportyRepository.findAll();
        if(sportyDTOS.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(sportyDTOS, HttpStatus.OK);
    }

}
