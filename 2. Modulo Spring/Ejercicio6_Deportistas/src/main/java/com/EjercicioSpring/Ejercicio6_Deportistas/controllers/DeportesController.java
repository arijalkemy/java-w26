package com.EjercicioSpring.Ejercicio6_Deportistas.controllers;

import com.EjercicioSpring.Ejercicio6_Deportistas.dto.DeporteDTO;
import com.EjercicioSpring.Ejercicio6_Deportistas.dto.DeportistaDTO;
import com.EjercicioSpring.Ejercicio6_Deportistas.entities.Deporte;
import com.EjercicioSpring.Ejercicio6_Deportistas.services.DeportistasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeportesController {

    private DeportistasService deportistasService = new DeportistasService();

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> getDeportes() {
        List<DeporteDTO> deportes = deportistasService.getAllDeportes();
        if (deportes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(deportes);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> getDeporteByName(@PathVariable String name) {
        DeporteDTO deporte = deportistasService.getDeporteByName(name);
        if (deporte == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(deporte);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> getDeportistas() {
        List<DeportistaDTO> deportistas = deportistasService.getDeportistas();
        if (deportistas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(deportistas);
    }

}
