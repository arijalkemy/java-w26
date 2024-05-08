package com.bootcamp.covid19.controller;

import com.bootcamp.covid19.dto.Sintoma.NivelGravedadSintomaDto;
import com.bootcamp.covid19.dto.Sintoma.SintomaDto;
import com.bootcamp.covid19.service.Interfaces.ISintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sintomas")
public class SintomasController {
    @Autowired
    private ISintomaService sintomaService;

    @GetMapping("findsymptom")
    public ResponseEntity<List<SintomaDto>> getAll(){

        return ResponseEntity.ok(sintomaService.getAll());
    }

    @GetMapping("/findsymptom/{name}")
    public ResponseEntity<NivelGravedadSintomaDto> getByName(@PathVariable String name){

        NivelGravedadSintomaDto nivelGravedadSintomaDto = sintomaService.getByName(name);

        if(nivelGravedadSintomaDto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(nivelGravedadSintomaDto);
    }
}
