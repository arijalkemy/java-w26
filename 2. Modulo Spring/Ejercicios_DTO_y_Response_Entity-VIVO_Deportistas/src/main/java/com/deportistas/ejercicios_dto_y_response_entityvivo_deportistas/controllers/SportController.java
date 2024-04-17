package com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.controllers;

import com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.models.Sport;
import com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.service.sportimpl.SportImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RestController
public class SportController {

    @Autowired
    SportImpl sportImp;

    @GetMapping
    public List<Sport> getAllSport() {
        return sportImp.getAllSports();
    }

    //?sportName=Basquetball

    @GetMapping("/findSport")
    public ResponseEntity<Integer> findSport(@RequestParam String sportName){
        return sportImp.findSport(sportName);
    }

}
