package org.example.templatemvc.Controller;


import lombok.RequiredArgsConstructor;
import org.example.templatemvc.Repository.Entity.Siniestro;
import org.example.templatemvc.Service.in.ISiniestroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/siniestro")
@RequiredArgsConstructor
public class SiniestroController {

    private final ISiniestroService service;


    @GetMapping("/list")
    public ResponseEntity<List<Siniestro>> searchAll() {
        return ResponseEntity.ok(service.searchAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Siniestro> create(@RequestBody Siniestro request) {
        return ResponseEntity.ok(service.create(request));
    }

}
