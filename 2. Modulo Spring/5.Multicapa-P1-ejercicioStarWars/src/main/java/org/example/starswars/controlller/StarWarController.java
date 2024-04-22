package org.example.starswars.controlller;


import org.example.starswars.DTO.CharacterDto;
import org.example.starswars.service.IfindService;
import org.example.starswars.service.serviceImpl.FindServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarController {
    @Autowired
    IfindService findService;

    @GetMapping("/{characterName}")
    public ResponseEntity<List<CharacterDto>> getChacaracters(@PathVariable String characterName){
        return ResponseEntity.ok(findService.findCharacters(characterName));
    }
}
