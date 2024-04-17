package com.EjercicioDeportista.EjercicioDeportista.controller;

import com.EjercicioDeportista.EjercicioDeportista.clases.Deporte;
import com.EjercicioDeportista.EjercicioDeportista.clases.dto.DeportistaDTO;
import com.EjercicioDeportista.EjercicioDeportista.services.IDeporteService;
import com.EjercicioDeportista.EjercicioDeportista.utils.Datos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deporte")
public class DeporteController {

    @Autowired
    IDeporteService deporteService;

    @GetMapping("/findSports")
    @ResponseBody
    public ResponseEntity<List<Deporte>> findSports() {
        List<Deporte> listaDeportes = Datos.obtenerDeportes();
        return new ResponseEntity<>(listaDeportes, HttpStatus.OK);
    }

    @GetMapping("findSports/{name}")
    @ResponseBody
    public ResponseEntity<?> findSportsName(@PathVariable String name) {

        Optional<Deporte> deporte = deporteService.findSportsName(name);
        if (deporte.isEmpty()) {
            return new ResponseEntity<>("No existe el deporte: "+ name, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(deporte.get(), HttpStatus.OK);
    }
    @GetMapping("/findSportsPersons")
    @ResponseBody
    public ResponseEntity<List<DeportistaDTO>> findSportsPersons() {
        List<DeportistaDTO> listaDeportistas = Datos.obtenerDeportistas();
        return new ResponseEntity<>(listaDeportistas, HttpStatus.OK);
    }



}
