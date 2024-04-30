package Ejercicio.ObtenerDiploma.controller;

import Ejercicio.ObtenerDiploma.dto.StudentDTO;
import Ejercicio.ObtenerDiploma.service.ICertificateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CertificateController {
    @Autowired
    ICertificateService service;

    @PostMapping("/analyzeScores")
    public ResponseEntity<StudentDTO> analyzeScores(@Valid @RequestBody StudentDTO studentDtoRequest) {
        StudentDTO studentDTOResponse = service.analyzeScores(studentDtoRequest);
        return new ResponseEntity<StudentDTO>(studentDTOResponse, HttpStatus.OK);
    }
}




