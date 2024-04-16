package org.example.dtosport.controller;

import org.example.dtosport.entity.Sport;
import org.example.dtosport.service.ISport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sport")
public class SportController {

    private final ISport isport;

    public SportController(@Autowired ISport isport) {
        this.isport = isport;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Sport>> findAll() {
        return ResponseEntity.ok().body(this.isport.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Sport> findByName(@PathVariable String name) {
        return ResponseEntity.ok().body(this.isport.findByName(name));
    }
}
