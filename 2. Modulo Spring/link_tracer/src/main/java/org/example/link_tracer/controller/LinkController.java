package org.example.link_tracer.controller;

import org.example.link_tracer.dto.LinkRequestDTO;
import org.example.link_tracer.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {
    @Autowired
    ILinkService linkService;

    @PostMapping("/new")
    public ResponseEntity<?> postNewLink(@RequestBody LinkRequestDTO newLink){
        return ResponseEntity.ok("");
    }
    @GetMapping("/link/{id}")
    public ResponseEntity<?> getRedirectLink(@PathVariable Integer id){
        return ResponseEntity.ok("");
    }
    @GetMapping("/metrics/{id}")
    public ResponseEntity<?> getMetricsLink(@PathVariable Integer id){
        return ResponseEntity.ok("");
    }
    @PostMapping("/invalidate/{id}")
    public ResponseEntity<?> postInvalidateLink(@PathVariable Integer id){
        return ResponseEntity.ok("");
    }

}
