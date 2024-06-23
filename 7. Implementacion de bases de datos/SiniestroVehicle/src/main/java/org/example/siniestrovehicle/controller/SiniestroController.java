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

    @Autowired
    private ISiniestroService siniestroService;

    @GetMapping("matricula-marca-modelo")
    public ResponseEntity<?> getMatriculaMarcaModelo() {
        return new ResponseEntity<>(siniestroService.getSiniestroMoreThat10000(), HttpStatus.OK);
    }

    @GetMapping("matricula-marca-modelo-perdida")
    public ResponseEntity<?> getMatriculaMarcaModeloPerdida() {
        return new ResponseEntity<>(siniestroService.getSiniestroPerdidaMoreThat10000(), HttpStatus.OK);
    }

}
