package spring.obtenerdiploma.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.obtenerdiploma.model.StudentDTO;
import spring.obtenerdiploma.service.IObtenerDiplomaService;



@RequiredArgsConstructor
@RestController
@Validated
public class obtenerDiplomaController {

    final IObtenerDiplomaService  service;

    @PostMapping("/analyzeScores")
    public StudentDTO analyzeScores(@Valid @RequestBody StudentDTO rq) {
        return service.analyzeScores(rq);
    }
}
