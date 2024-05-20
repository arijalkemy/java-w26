package com.example.miniseries.controller;

import com.example.miniseries.model.Miniserie;
import com.example.miniseries.repository.IMiniserieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/miniserie")
@Validated
public class MiniserieController {

    @Autowired
    IMiniserieRepository repo;

    @PostMapping("/add")
    public ResponseEntity<?> addMiniserie(@RequestBody Miniserie miniserie){
        repo.save(miniserie);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Miniserie>> getMiniserie() {
        return ResponseEntity.ok().body(repo.findAll());
    }
}
