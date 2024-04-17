package com.bootcampjava.covid19.controller;

import com.bootcampjava.covid19.model.DTOs.SintomaDTO;
import com.bootcampjava.covid19.model.Sintoma;
import com.bootcampjava.covid19.service.ISintomasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class SintomaController {

   @Autowired
   ISintomasService sintomaService;
    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> obtenerSintomas(){
        return ResponseEntity.ofNullable(sintomaService.obtenerTodosSintomas());
    }
    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity <SintomaDTO> obtenerSintomaPorNombre(@PathVariable String nombre){
        return ResponseEntity.ofNullable(sintomaService.obtenerSintomaPorNombre(nombre));
    }

}
