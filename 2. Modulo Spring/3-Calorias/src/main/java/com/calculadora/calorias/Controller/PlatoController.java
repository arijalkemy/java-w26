package com.calculadora.calorias.Controller;

import com.calculadora.calorias.Dto.PlatoRequestDto;
import com.calculadora.calorias.Service.Interface.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatoController {

    @Autowired
    IPlatoService platoService;

    @GetMapping("/calorias/")
    public ResponseEntity<?> getCalorias(@RequestBody PlatoRequestDto requestDto){
        return new ResponseEntity(platoService.getCalorias(requestDto), HttpStatus.OK);
    }

    @GetMapping("/calorias/ingredientes/")
    public ResponseEntity<?> getIngredientes(@RequestBody PlatoRequestDto requestDto){
        return new ResponseEntity(platoService.getIngredients(requestDto), HttpStatus.OK);
    }

    @GetMapping("/calorias/ingredientes/mas_calorias")
    public ResponseEntity<?> getIngredienteMasCalorias(@RequestBody PlatoRequestDto requestDto){
        return new ResponseEntity(platoService.getIngredienteConMasCalorias(requestDto), HttpStatus.OK);
    }
}
