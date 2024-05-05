package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ObtenerDiplomaController {

    @Autowired
    IObtenerDiplomaService service;

    @GetMapping("/analyzeScores/{studentId}")

    public ResponseEntity<StudentDTO> analyzeScores(@PathVariable Long studentId) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(service.analyzeScores(studentId));
    }
}
