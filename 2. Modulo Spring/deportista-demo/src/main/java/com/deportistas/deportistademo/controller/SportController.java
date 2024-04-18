package com.deportistas.deportistademo.controller;

import com.deportistas.deportistademo.entity.Sport;
import com.deportistas.deportistademo.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sport")
public class SportController {

    SportService sportService;

    @Autowired
    public SportController(SportService sportService) {
        this.sportService = sportService;
    }


    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> getAllSports(){
        List<Sport> response = this.sportService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<Sport> findSport(@PathVariable String name){
        System.out.println(name);
        Sport response = this.sportService.getByName(name);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
