package com.meli.covid19.controllers;

import com.meli.covid19.dto.SintomaDTO;
import com.meli.covid19.services.ISintoma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sintomas")
public class SintomaController {

    @Autowired
    ISintoma sintomaService;

    @GetMapping("/versintomas")
    public ResponseEntity<List<SintomaDTO>> verSintomas(){
        return new ResponseEntity<>(sintomaService.verSintomas(), HttpStatus.OK);
    }

    @GetMapping("/buscarsintoma/")
    public ResponseEntity<String> buscarSintoma(@RequestParam String nombre){
        String result = sintomaService.buscarSintoma(nombre);
        if(result.equals("No registrado")){
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

}
