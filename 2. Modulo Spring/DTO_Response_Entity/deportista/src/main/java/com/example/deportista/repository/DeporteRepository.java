package com.example.deportista.repository;

import com.example.deportista.dto.PersonaDTO;
import com.example.deportista.model.Deporte;
import com.example.deportista.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class DeporteRepository {
    private static List<Deporte> deportes = new ArrayList<>(){{
        Deporte futbol = new Deporte("futbol","profesional");
        add(futbol);
    }};
    public static List<Deporte> getDeportes() {
        return DeporteRepository.deportes;
    }
}
