package com.mercadolibre.Covid19API.controller;

import com.mercadolibre.Covid19API.model.Sintoma;
import com.mercadolibre.Covid19API.services.ISintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/sintoma")
public class SintomaController {
    @Autowired
    ISintomaService sintomaService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> getAllSintoma(){
        return ResponseEntity.status(HttpStatus.OK).body(sintomaService.obtSyntomas());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> getSintoma(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(sintomaService.obtSyntomaPorNombre(name));
    }
}
