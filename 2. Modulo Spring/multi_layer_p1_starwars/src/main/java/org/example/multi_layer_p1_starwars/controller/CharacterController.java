package org.example.multi_layer_p1_starwars.controller;

import org.example.multi_layer_p1_starwars.dto.CharacterDTO;
import org.example.multi_layer_p1_starwars.service.CharacterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CharacterController {
    @Autowired
    private CharacterServiceImpl service;

    @GetMapping("/findByName")
    public List<CharacterDTO> findByName(@RequestParam String name) {
        return service.findByName(name);
    }
}
