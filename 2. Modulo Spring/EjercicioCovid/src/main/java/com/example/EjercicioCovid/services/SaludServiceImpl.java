package com.example.EjercicioCovid.services;

import com.example.EjercicioCovid.dto.PersonaDTO;
import com.example.EjercicioCovid.dto.SintomaDTO;
import com.example.EjercicioCovid.model.Persona;
import com.example.EjercicioCovid.model.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaludServiceImpl implements SaludService {
    private List<Sintoma> sintomas = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();

    public SaludServiceImpl() {
        // Agregar síntomas harcodeados
        sintomas.add(new Sintoma(1L, "Fiebre", "Alto"));
        sintomas.add(new Sintoma(2L, "Tos", "Medio"));
        sintomas.add(new Sintoma(3L, "Dolor de cabeza", "Bajo"));

        // Agregar personas harcodeadas
        personas.add(new Persona(1L, "Juan", "Perez", 35));
        personas.add(new Persona(2L, "María", "González", 40));
        personas.add(new Persona(3L, "Carlos", "López", 70));
        personas.add(new Persona(4L, "Ana", "Martínez", 65));
    }

    @Override
    public List<SintomaDTO> findAllSymptoms() {
        return sintomas.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public String findSymptomByName(String name) {
        for (Sintoma sintoma : sintomas) {
            if (sintoma.getNombre().equals(name)) {
                return "Nivel de gravedad del sintoma " + name + ": " + sintoma.getNivelDeGravedad();
            }
        }
        return null;
    }

    @Override
    public List<PersonaDTO> findHighRiskPersons() {
        return personas.stream().filter(persona -> persona.getEdad() > 60).filter(this::hasSymptom).map(this::convertToDTO).collect(Collectors.toList());
    }

    private boolean hasSymptom(Persona persona) {
        // Lógica para verificar si la persona tiene al menos un síntoma asociado
        return true;
    }

    private SintomaDTO convertToDTO(Sintoma sintoma) {
        SintomaDTO dto = new SintomaDTO();
        dto.setNombre(sintoma.getNombre());
        dto.setNivelDeGravedad(sintoma.getNivelDeGravedad());
        return dto;
    }

    private PersonaDTO convertToDTO(Persona persona) {
        PersonaDTO dto = new PersonaDTO();
        dto.setNombre(persona.getNombre());
        dto.setApellido(persona.getApellido());
        return dto;
    }
}
