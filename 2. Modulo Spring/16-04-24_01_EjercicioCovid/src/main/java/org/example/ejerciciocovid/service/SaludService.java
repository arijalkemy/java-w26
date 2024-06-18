package org.example.ejerciciocovid.service;

import org.example.ejerciciocovid.dto.RiskPersonDTO;
import org.example.ejerciciocovid.model.Persona;
import org.example.ejerciciocovid.model.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaludService {
    private List<Sintoma> sintomas = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();

    public SaludService() {
        // Inicializar síntomas
        sintomas.add(new Sintoma("S1", "Fiebre", 5));
        sintomas.add(new Sintoma("S2", "Tos", 3));
        sintomas.add(new Sintoma("S3", "Dolor de cabeza", 2));

        // Inicializar personas
        personas.add(new Persona(1L, "Juan", "Perez", 65));
        personas.add(new Persona(2L, "Maria", "Gomez", 70));
        personas.add(new Persona(3L, "Carlos", "Lopez", 55));
    }

    public List<Sintoma> findAllSymptoms() {
        return sintomas;
    }

    public Sintoma findSymptomByName(String name) {
        return sintomas.stream()
                .filter(s -> s.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<RiskPersonDTO> findRiskPersons() {
        return personas.stream()
                .filter(persona -> persona.getEdad() > 60)
                .map(persona -> new RiskPersonDTO(persona.getNombre(), persona.getApellido()))
                .collect(Collectors.toList());
    }
}

