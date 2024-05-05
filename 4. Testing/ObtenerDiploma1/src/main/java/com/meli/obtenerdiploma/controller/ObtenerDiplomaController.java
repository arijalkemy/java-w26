package com.meli.obtenerdiploma.controller;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@Validated
public class ObtenerDiplomaController {

    @Autowired
    IObtenerDiplomaService service;

    @PostMapping("/analyzeScores")
    public ResponseEntity<StudentDTO> analyzeScores(@Valid @RequestBody StudentDTO rq){
        if (!service.isFirstLetterUpperCase(rq.getStudentName())) {
            return ResponseEntity.badRequest().build();
        }
        if (rq.getSubjects().stream().anyMatch(e -> !service.isFirstLetterUpperCase(e.getName()))){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.analyzeScores(rq));
    }

}
