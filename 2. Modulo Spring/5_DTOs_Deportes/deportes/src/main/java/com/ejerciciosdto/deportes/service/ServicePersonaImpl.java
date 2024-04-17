package com.ejerciciosdto.deportes.service;

import com.ejerciciosdto.deportes.dto.PersonaDTO;
import com.ejerciciosdto.deportes.models.Deporte;
import com.ejerciciosdto.deportes.models.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicePersonaImpl implements IPersona {
    Deporte futbol = new Deporte("Futbol", "Avanzado");
    Deporte basquet = new Deporte("Basquet", "Intermedio");
    Deporte baseball = new Deporte("Baseball", "INtermedio");
    Persona persona_uno = new Persona("Juan", "Gonzalez", 23, futbol);
    Persona persona_dos = new Persona("Luis", "Palermo", 34, baseball);
    Persona persona_tres = new Persona("Andrea", "Gomez", 24);
    List<Persona> personas = List.of(persona_uno, persona_dos, persona_tres);

    @Override
    public List<PersonaDTO> getPersonsAndSports() {
        return personas.stream().map(dto -> new PersonaDTO(dto.getNombre(), dto.getApellido(), dto.getDeporte().getNombre())).toList();
    }
}
