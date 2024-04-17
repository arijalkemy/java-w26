package org.ggomezr.covid19.application.controller;

import org.ggomezr.covid19.application.service.impl.SintomaService;
import org.ggomezr.covid19.domain.entity.Sintoma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.List;

@RestController
public class SintomaController {
    @Autowired
    private SintomaService sintomaService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> findAllSymptoms(){
        List<Sintoma> sintomas = sintomaService.findAllSymptoms();
        if(!sintomas.isEmpty()) return new ResponseEntity<>(sintomas, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findSymptom(@PathVariable String name){
        String mensaje = sintomaService.findSymptom(name);
        if(mensaje != null){
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
