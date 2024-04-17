package com.meli.bootcamp.EjercicioDeportistas.service;


import com.meli.bootcamp.EjercicioDeportistas.dto.DeportistaDTO;
import com.meli.bootcamp.EjercicioDeportistas.model.Deporte;
import com.meli.bootcamp.EjercicioDeportistas.model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Servicio {

    private final List<Persona> personas = new ArrayList<>();
    private final List<Deporte> deportes = new ArrayList<>();

    public Servicio() {
        // Inicializar deportes
        deportes.add(new Deporte("Fútbol", "Intermedio"));
        deportes.add(new Deporte("Baloncesto", "Avanzado"));
        deportes.add(new Deporte("Natación", "Principiante"));
        deportes.add(new Deporte("Tenis", "Intermedio"));

        // Inicializar personas
        personas.add(new Persona("Juan", "Pérez", 30, deportes.get(0))); // Asociado al fútbol
        personas.add(new Persona("María", "Gómez", 25, deportes.get(1))); // Asociado al baloncesto
        personas.add(new Persona("Carlos", "Fernández", 20, deportes.get(2))); // Asociado a la natación
        personas.add(new Persona("Ana", "Martínez", 28, deportes.get(3))); // Asociado al tenis
    }

    public List<Deporte> findAllSports() {
        return deportes;
    }

    public Deporte findSportByName(String name) {
        return deportes.stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<DeportistaDTO> findAllSportsPersons() {
        List<DeportistaDTO> dtoList = new ArrayList<>();
        for (Persona p : personas) {
            dtoList.add(new DeportistaDTO(p.getNombre(), p.getApellido(), p.getDeporte().getNombre()));
        }
        return dtoList;
    }
}
