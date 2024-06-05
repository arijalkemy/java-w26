package org.meli.obtenerdiploma.controller;

import jakarta.validation.Valid;
import org.meli.obtenerdiploma.model.StudentDTO;
import org.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ObtenerDiplomaController {

    @Autowired
    IObtenerDiplomaService service;

    @PostMapping("/analyzeScores")
    public StudentDTO analyzeScores(@RequestBody @Valid StudentDTO rq) {

        return service.analyzeScores(rq);

    }
}
