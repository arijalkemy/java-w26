package com.deportista.deportista.controller;

import com.deportista.deportista.Datos;
import com.deportista.deportista.dto.PersonaDto;
import com.deportista.deportista.entity.Deporte;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DeporteController {

    Datos datos = new Datos();

    @GetMapping("/findSports")
    public List<Deporte> verDeportes(){
        return datos.getDeportes();
    }

    @GetMapping("/findSport/{nombre}")
    public ResponseEntity<Deporte> verDeporteNombre(@PathVariable String nombre){
      Deporte deporteEncontrado = datos.getDeportePorNombre(nombre);
      if(deporteEncontrado != null){
          return ResponseEntity.ok(deporteEncontrado);
      }
      return ResponseEntity.notFound().build();
    }

    @GetMapping("/findSportsPersons")
    public List<PersonaDto> verPersona(){
        return datos.getPersonas().stream()
                .map(e-> new PersonaDto(e.getNombre(), e.getApellido(), e.getDeporte().getNombre()))
                .collect(Collectors.toList());
    }

}
