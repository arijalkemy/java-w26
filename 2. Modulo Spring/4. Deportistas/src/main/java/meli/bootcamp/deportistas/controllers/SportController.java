package meli.bootcamp.deportistas.controllers;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.deportistas.entities.Sport;
import meli.bootcamp.deportistas.services.SportImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sport")
@RequiredArgsConstructor
public class SportController {
    private final SportImpl sportImpl;

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Sport>> findAll() {
        return new ResponseEntity<>(sportImpl.getAll(), HttpStatus.OK);
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<?> findSport(@PathVariable String name) {
        return ResponseEntity.status(200).body(sportImpl.getOne(name).getLevel());
    }
}
