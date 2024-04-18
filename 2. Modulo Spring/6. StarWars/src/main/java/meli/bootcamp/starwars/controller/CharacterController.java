package meli.bootcamp.starwars.controller;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.starwars.dto.CharacterDto;
import meli.bootcamp.starwars.service.CharacterImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterImpl starWars;

    @GetMapping("/search")
    public ResponseEntity<List<CharacterDto>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(starWars.getByName(name));
    }
}
