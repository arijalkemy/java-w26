package com.deportistas.excercise.controller;

import com.deportistas.excercise.dto.PersonaDTO;
import com.deportistas.excercise.model.Deporte;
import com.deportistas.excercise.model.Persona;
import com.deportistas.excercise.service.impl.IDeportesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sports")
public class DeportistasController {

    @Autowired
    private IDeportesServiceImpl iDeportesService;


    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> getAllDeportes(){

        List<Deporte> listaDeportes =  iDeportesService.getDeportes();

        if (listaDeportes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(listaDeportes, HttpStatus.OK);
    }

    @GetMapping("/findSports/{nombre}")
    public ResponseEntity<String> getDeporteByName(@PathVariable String nombre){

        Deporte deportEncontrado = iDeportesService.getDeporteByName(nombre);

        if (deportEncontrado == null) {
            return new ResponseEntity<>( "No se encontró el deporte ingresado.", HttpStatus.NOT_FOUND);
        }

        String bodyRespuesta = "El deporte " + deportEncontrado +" se encuentra en la base y posee un nivel " + deportEncontrado.getNivel();

        return new ResponseEntity<>(bodyRespuesta, HttpStatus.OK);
    }

    @GetMapping("/findSportyPeople")
    public ResponseEntity<List<PersonaDTO>> getAllDeportyPeople(){


        List<PersonaDTO> listaPersonasDeportistas = iDeportesService.getPersonasDeportistas();

        if (listaPersonasDeportistas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(listaPersonasDeportistas, HttpStatus.OK);

    }
}
