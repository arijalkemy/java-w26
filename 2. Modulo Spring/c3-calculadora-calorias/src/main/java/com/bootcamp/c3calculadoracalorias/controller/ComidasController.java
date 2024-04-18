package com.bootcamp.c3calculadoracalorias.controller;

import com.bootcamp.c3calculadoracalorias.dto.PlatoDTO;
import com.bootcamp.c3calculadoracalorias.service.IComidasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComidasController {

    @Autowired
    IComidasService comidasService;

    @GetMapping("/caloriasPlato")
    public ResponseEntity<?> caloriasPorPlato(@RequestBody PlatoDTO plato){
        return new ResponseEntity<>(comidasService.caloriasPlato(plato), HttpStatus.OK);
    }

}
