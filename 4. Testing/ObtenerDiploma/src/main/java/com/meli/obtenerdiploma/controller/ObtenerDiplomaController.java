package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ObtenerDiplomaController {

    IObtenerDiplomaService service;

    public ObtenerDiplomaController(IObtenerDiplomaService service) {
        this.service = service;
    }

    @GetMapping("/analyzeScores/{studentId}")
    public StudentDTO analyzeScores(@PathVariable Long studentId) {
        return service.analyzeScores(studentId);
    }
}
