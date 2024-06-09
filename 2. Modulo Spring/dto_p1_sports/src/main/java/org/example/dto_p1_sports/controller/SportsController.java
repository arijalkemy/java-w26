package org.example.dto_p1_sports.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto_p1_sports.service.interfaces.ISportService;
import org.example.dto_p1_sports.entity.Sport;
import org.example.dto_p1_sports.dto.SportDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class SportsController {
    private final ISportService sportService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> getAllSports(){
        List<Sport> sportList = sportService.getAllSports();
        return ResponseEntity.ok(sportList);
    }
    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> getSportLevel(@PathVariable String name) {
        return ResponseEntity.ok(sportService.getSportLevel(name));
    }
    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportDTO>> getSportsByPerson() {
        List<SportDTO> sportDTOList = sportService.getPersonSport();
        return ResponseEntity.ok(sportDTOList);
    }
}
