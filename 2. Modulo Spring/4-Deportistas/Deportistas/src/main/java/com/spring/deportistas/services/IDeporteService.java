package com.spring.deportistas.services;

import com.spring.deportistas.DTOs.DeportistaDTO;
import com.spring.deportistas.models.Deporte;
import com.spring.deportistas.models.Persona;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public interface IDeporteService {
    static List<Deporte> deportes = List.of(new Deporte("Futbol", "amateur"),
            new Deporte("Tenis", "amateur"), new Deporte("Handball", "amateur"),
            new Deporte("Basquet", "amateur"));

    static List<Persona> personas = List.of(new Persona("Maca", "Caridad", 29, deportes.get(1)),
            new Persona("Angel", "Lopez", 30, deportes.get(2)));

    List<String> consultarDeportes();

    Deporte buscarUnDeporte(String nombre);

    List<DeportistaDTO> buscarDeportistas();

}
