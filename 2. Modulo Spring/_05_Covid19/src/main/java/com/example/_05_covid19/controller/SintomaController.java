package com.example._05_covid19.controller;

import com.example._05_covid19.model.Sintoma;
import com.example._05_covid19.service.ISintomaService;
import com.example._05_covid19.service.SintomaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SintomaController {
    @Autowired
    ISintomaService iSintomaService;


    @GetMapping("/findSymptom")
    @ResponseBody
    public ResponseEntity<List<Sintoma>> obtenerSintomas(){
        List<Sintoma> sintomas = iSintomaService.obtenerSintomas();

        if(sintomas.size()==0)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(sintomas, HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{nombre}")
    @ResponseBody
    public ResponseEntity<Sintoma> obtenerSintoma(@PathVariable String nombre){
        Sintoma sintoma = iSintomaService.obtenerSintoma(nombre);

        if(sintoma == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(sintoma, HttpStatus.OK);
    }
}
