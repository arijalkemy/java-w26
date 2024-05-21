package com.example.sinisestros.controller;

import com.example.sinisestros.models.ResponseDto;
import com.example.sinisestros.service.ISiniestroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/siniestro")
@RequiredArgsConstructor
public class SiniestroController {
    private final ISiniestroService siniestroserv;

    @PostMapping("/")
    private ResponseDto postSiniestro(){
        //to do agregar funciones
        return new ResponseDto("siniestro creado con exito");
    }

    @GetMapping("/")
    private ResponseEntity<?> getSiniestros(){
        //to do agregar funciones
        return  ResponseEntity.status(HttpStatus.OK).body(siniestroserv.getinformacionVehiculoSiniestroMayoraDiezMil());
    }

}
