package org.example.dtosport.controller;

import org.example.dtosport.entity.dto.SportPersonDto;
import org.example.dtosport.service.ISportPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class SportPersonController {

    private final ISportPerson iSportPerson;

    public SportPersonController(@Autowired ISportPerson iSportPerson) {
        this.iSportPerson = iSportPerson;
    }

    @GetMapping("/all")
    public ResponseEntity<List<SportPersonDto>> getSportPerson() {
        return ResponseEntity.ok().body(this.iSportPerson.findSportPerson());
    }
}
