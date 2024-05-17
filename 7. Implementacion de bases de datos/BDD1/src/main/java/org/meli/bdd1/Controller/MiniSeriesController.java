package org.meli.bdd1.Controller;

import lombok.RequiredArgsConstructor;
import org.meli.bdd1.Entity.MiniSeries;
import org.meli.bdd1.Service.MiniSeriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/miniseries")
@RequiredArgsConstructor
public class MiniSeriesController {

    private final MiniSeriesService service;


    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody MiniSeries miniSeries) {
        return ResponseEntity.ok(service.create(miniSeries));
    }

}
