package com.example.starwars.controlador;

import com.example.starwars.dto.DTOPersonaje;
import com.example.starwars.modelo.Personaje;
import com.example.starwars.repositorio.RepositorioPersonaje;
import com.example.starwars.servicio.IServicioPersonaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorPersonaje {
    @Autowired
    private IServicioPersonaje servicioPersonaje;

    @GetMapping("/personajes")
    @ResponseBody
    public List<Personaje> obtenerPersonajes(){
        return servicioPersonaje.generarListaPersonaje();
    }

    @GetMapping("/personajes/{filtro}")
    @ResponseBody
    public List<DTOPersonaje> obtenerPersonajesPorFiltro(@PathVariable String filtro){
        return servicioPersonaje.generarListaPersonajePorFiltro(filtro);
    }


}
