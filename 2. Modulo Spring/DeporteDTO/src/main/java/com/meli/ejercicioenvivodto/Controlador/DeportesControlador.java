package com.meli.ejercicioenvivodto.Controlador;

import com.meli.ejercicioenvivodto.Repository.DTO.DeporteDTO;
import com.meli.ejercicioenvivodto.Service.IDeportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sports")
public class DeportesControlador {

    @Autowired
    private IDeportesService deportesServicio;
    @GetMapping("/findSports")
    public String findSports() {
        return deportesServicio.listaDeportes().toString();
    }

    @GetMapping("/findSport/{nombre}")
    public String findSport(@PathVariable String nombre) {
        return deportesServicio.nombreDeporte(nombre);
    }

    @GetMapping("/findSportsPersons")
    public String findSportsPersons(){
        return deportesServicio.listaPersonas().toString();
    }
}
