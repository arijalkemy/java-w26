package com.example.ejercicio_dto_y_response_entity_vivo.service.impl;

import com.example.ejercicio_dto_y_response_entity_vivo.api.dto.PersonaDeportistaDTO;
import com.example.ejercicio_dto_y_response_entity_vivo.persistence.model.Deporte;
import com.example.ejercicio_dto_y_response_entity_vivo.persistence.model.Persona;
import com.example.ejercicio_dto_y_response_entity_vivo.service.IDeporteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class DeporteServiceImpl implements IDeporteService {
    private List<Deporte> deportes;
    private List<Persona> personas;

    public DeporteServiceImpl() {
        deportes = new ArrayList<>() {{
            add(new Deporte("Futbol", "Profesional"));
            add(new Deporte("Basquet", "Amateur"));
            add(new Deporte("Padel", "Amateur"));
        }};
        personas = new ArrayList<>() {{
            add(new Persona("Jose", "Sosa", 20));
            add(new Persona("Maria", "Fernandez", 18));
            add(new Persona("Juan", "Lucero", 30));
        }};
    }

    public List<Deporte> getDeportes() {
        return deportes;
    }

    public Optional<Deporte> consultarDeportePorNombre(String name) {
        return deportes.stream().filter(d -> d.getNombre().equals(name)).findFirst();
    }

    public List<PersonaDeportistaDTO> obtenerPersonasDeportistas() {
        List<PersonaDeportistaDTO> personasDeportistasDTO = new ArrayList<>();
        for(Persona persona : personas) {
            Random random = new Random();
            int randomSport = random.nextInt(3); // Generate a random number between 0 and 2 (inclusive)
            PersonaDeportistaDTO dto =
                    new PersonaDeportistaDTO(
                            persona.getNombre(), persona.getApellido(),
                            deportes.get(randomSport).getNombre());

            personasDeportistasDTO.add(dto);
        }
        return personasDeportistasDTO;
    }
}
