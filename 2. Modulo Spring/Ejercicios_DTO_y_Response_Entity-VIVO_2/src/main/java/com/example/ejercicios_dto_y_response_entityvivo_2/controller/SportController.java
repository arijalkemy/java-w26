package com.example.ejercicios_dto_y_response_entityvivo_2.controller;

import com.example.ejercicios_dto_y_response_entityvivo_2.dto.DeportistDTO;
import com.example.ejercicios_dto_y_response_entityvivo_2.dto.SportDTO;
import com.example.ejercicios_dto_y_response_entityvivo_2.service.ISportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class SportController {

    @Autowired
    ISportService sportService;

    @GetMapping("/findSports")
    ResponseEntity<List<SportDTO>> getAllSports(){
        return new ResponseEntity<>(sportService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    ResponseEntity<SportDTO> getSport(@PathVariable String name){
        return new ResponseEntity<>(sportService.getSport(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    ResponseEntity<List<DeportistDTO>> getDeportist(){
        return new ResponseEntity<>(sportService.getDeportist(),HttpStatus.OK);
    }
}
