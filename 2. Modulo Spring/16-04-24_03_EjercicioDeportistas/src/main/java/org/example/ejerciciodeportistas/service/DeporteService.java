package org.example.ejerciciodeportistas.service;

import org.example.ejerciciodeportistas.dto.DeportistaDTO;
import org.example.ejerciciodeportistas.model.Deporte;
import org.example.ejerciciodeportistas.model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeporteService {
    private List<Deporte> deportes = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();

    // inicializar algunos datos
    public DeporteService() {
        // Inicializar algunos deportes
        deportes.add(new Deporte("Fútbol", "Alto"));
        deportes.add(new Deporte("Ciclismo", "Medio"));
        deportes.add(new Deporte("Natación", "Bajo"));

        // Inicializar algunas personas
        personas.add(new Persona("Juan", "Perez", 25));
        personas.add(new Persona("Maria", "Gomez", 30));
        personas.add(new Persona("Carlos", "Lopez", 22));
    }

    public List<Deporte> findAllSports() {
        return deportes;
    }

    public Deporte findSportByName(String name) {
        return deportes.stream()
                .filter(deporte -> deporte.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<DeportistaDTO> findSportsPersons() {
        // Relacionar personas con deportes
        List<DeportistaDTO> deportistas = new ArrayList<>();
        for (Persona persona : personas) {
            for (Deporte deporte : deportes) {
                deportistas.add(new DeportistaDTO(persona.getNombre(), persona.getApellido(), deporte.getNombre()));
            }
        }
        return deportistas;
    }
}

