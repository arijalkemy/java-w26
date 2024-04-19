package com.sinc_ejerciciodeportistas.controlador;

import com.sinc_ejerciciodeportistas.dto.DeporteDTO;
import com.sinc_ejerciciodeportistas.entidades.Deporte;
import com.sinc_ejerciciodeportistas.repositorio.Repositorio;
import com.sinc_ejerciciodeportistas.servicio.IDeporteServicio;
import com.sinc_ejerciciodeportistas.servicio.IPersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class DeporteControlador {

    @Autowired
    IDeporteServicio iDeporteServicio;

    @GetMapping(path = "/findSports")
    public ResponseEntity<List<DeporteDTO>> obtenerTodosLosDeportes() {
        return new ResponseEntity(iDeporteServicio.obtenerTodosLosDeportes(), HttpStatus.OK);
    }

    //prueba: localhost:8080/findSports

    @GetMapping(path = "/findSport/{nombreDeporte}")
    public ResponseEntity<String> buscarDeportePorNombre(@PathVariable String nombreDeporte) {
        return new ResponseEntity<>(iDeporteServicio.buscarDeportePorNombre(nombreDeporte), HttpStatus.OK);
    }

    //prueba: localhost:8080/findSport/Tenis



}
