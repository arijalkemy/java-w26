package com.w26.deportista.deportistas.controlador;

import com.w26.deportista.deportistas.modelo.Deporte;
import com.w26.deportista.deportistas.servicio.ServicioBusquedaDeportes;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log
@RestController
@RequestMapping("/deporte")
public class ControladorDeporte {

    private final ServicioBusquedaDeportes servicioBusqueda;

    public ControladorDeporte(ServicioBusquedaDeportes servicioBusqueda) {
        this.servicioBusqueda = servicioBusqueda;
    }

    @GetMapping(value = {"/encontrarDeportes/{nombre}","/encontrarDeportes/" })
    public ResponseEntity<List<Deporte>> encontrarDeportes(@PathVariable(required = false) String nombre)
    {
        List<Deporte> deportesEncontrados = null;
        log.info("VARIABLE: " + nombre);
        if (nombre != null){
            deportesEncontrados = servicioBusqueda.encontrarDeportes(nombre);
        } else {
            deportesEncontrados = servicioBusqueda.encontrarDeportes();
        }
        return new ResponseEntity<>(deportesEncontrados, HttpStatus.OK);
    }
}
