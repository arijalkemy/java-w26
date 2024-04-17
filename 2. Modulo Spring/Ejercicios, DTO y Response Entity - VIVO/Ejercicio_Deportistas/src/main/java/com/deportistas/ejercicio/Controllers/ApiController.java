package com.deportistas.ejercicio.Controllers;


import com.deportistas.ejercicio.Classes.Deporte;
import com.deportistas.ejercicio.Classes.Persona;
import com.deportistas.ejercicio.Classes.PersonaDeportistaDTO;
import com.deportistas.ejercicio.Services.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
public class ApiController {

    private final DeporteService deporteService;

    @Autowired
    public ApiController(DeporteService deporteService) {
        this.deporteService = deporteService;
    }

    @GetMapping("/findSports")
    ResponseEntity<List<Deporte>> getAllDeportes() {
        return ResponseEntity.ok(deporteService.getAllDeportes());
    }

    @PostMapping("/addSport")
    ResponseEntity<String> addDeporte(@RequestBody Deporte deporte) {
        deporteService.addDeporte(deporte);
        return ResponseEntity.ok("Deporte añadido correctamente");
    }

    @PostMapping("/addPerson")
    public ResponseEntity<String> addPersona(@RequestBody Persona persona) {
        try {
            deporteService.addPersona(persona);
            return ResponseEntity.ok("Persona añadida correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/findSportByName/{name}")
    public String getDeporteByName(@PathVariable String name) {
        return deporteService.getDeporteByName(name);
    }

    @GetMapping("/findPersonsDeportes")
    public List<PersonaDeportistaDTO> getAllPersonasWithDeportes() {
        return deporteService.getAllPersonasWithDeportes();
    }
}
