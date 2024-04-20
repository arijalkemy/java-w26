package com.sinc_ejerciciostarwars.controlador;

import com.sinc_ejerciciostarwars.dto.PersonajeDTO;
import com.sinc_ejerciciostarwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeControlador {

    @Autowired
    private IPersonajeService iPersonajeService;

    @GetMapping(path = "/starwars")
    public List<PersonajeDTO> buscarTodos() {
        return iPersonajeService.buscarTodos();
    }
    //pruebas: localhost:8080/starwars

    @GetMapping(path = "/starwars/{nombrePersonaje}")
    public List<PersonajeDTO> buscarPorNombre(@PathVariable String nombrePersonaje) {
        return iPersonajeService.buscarPersonajePorNombre(nombrePersonaje);
    }
    //pruebas: localhost:8080/starwars/Luke
    //pruebas: localhost:8080/starwars/darth
}
