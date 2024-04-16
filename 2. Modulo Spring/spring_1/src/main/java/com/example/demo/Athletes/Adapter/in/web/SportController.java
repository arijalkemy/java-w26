package com.example.demo.Athletes.Adapter.in.web;

import com.example.demo.Athletes.Application.in.request.ISportsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sports")
@RequiredArgsConstructor
public class SportController {

    private final ISportsService sportsService;

    @GetMapping("/findSports")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(sportsService.findAll());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> getByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(sportsService.findByName(name));
    }
}
