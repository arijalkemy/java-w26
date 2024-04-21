package com.example.Sports.controllers;


import com.example.Sports.entity.Sport;
import com.example.Sports.dto.SportDTO;
import com.example.Sports.service.ISport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SportController {

    @Autowired
    ISport sportService;

    @GetMapping("/findAll")
    @ResponseBody
    public List<Sport> findAll() {
        return sportService.findAll();
    }

    @GetMapping("/find")
    public ResponseEntity<SportDTO> findByName(@RequestParam String sportName) {
        Sport sport = sportService.findByName(sportName);
        if (sport == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new SportDTO(sport.getLevel()));
    }

}
