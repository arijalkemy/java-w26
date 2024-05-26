package org.example.siniestrovehicle.controller;

import org.example.siniestrovehicle.entity.Vehicle;
import org.example.siniestrovehicle.service.ISiniestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/siniestro")
public class SiniestroController {
    private final ISiniestroService siniestroService;

    public SiniestroController(@Autowired ISiniestroService siniestroService) {
        this.siniestroService = siniestroService;
    }
}
