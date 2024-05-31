package com.Ejercicio.Deportistas.Controller;

import com.Ejercicio.Deportistas.DTO.SportDTO;
import com.Ejercicio.Deportistas.Service.ISportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportController {

    private final ISportService sportService;

    public SportController(ISportService sportService) {
        this.sportService = sportService;
    }

    @GetMapping("/findSports")
    public ResponseEntity<?> getAllSports() {
        List<SportDTO> sportDtoList = sportService.findAllSports();
        return new ResponseEntity<>(sportDtoList, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> getSportBy(@PathVariable String name){
        String sportLevel = sportService.findSportBy(name);
        return new ResponseEntity<>(sportLevel, HttpStatus.OK);
    }
}
