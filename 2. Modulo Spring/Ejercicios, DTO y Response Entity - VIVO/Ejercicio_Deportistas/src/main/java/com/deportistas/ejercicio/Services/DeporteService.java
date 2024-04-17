package com.deportistas.ejercicio.Services;

import com.deportistas.ejercicio.Classes.Deporte;
import com.deportistas.ejercicio.Classes.Persona;
import com.deportistas.ejercicio.Classes.PersonaDeportistaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeporteService {
    private List<Deporte> deportes = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();

    public void addDeporte(Deporte deporte) {
        deportes.add(deporte);
    }

    public List<Deporte> getAllDeportes() {
        return deportes;
    }

    public void addPersona(Persona persona) throws Exception {
        boolean exists = deportes.stream()
                .anyMatch(deporte -> deporte.getNombre().equalsIgnoreCase(persona.getDeporte().getNombre()));
        if (!exists) {
            throw new Exception("Deporte no existe");
        }
        personas.add(persona);
    }

    public String getDeporteByName(String nombre) {
        return deportes.stream()
                .filter(deporte -> deporte.getNombre().equalsIgnoreCase(nombre))
                .map(Deporte::getNivel)
                .collect(Collectors.toList()).toString();
    }

    public List<Persona> getAllPersonas() {
        return personas;
    }

    public List<PersonaDeportistaDTO> getAllPersonasWithDeportes() {
        return personas.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private PersonaDeportistaDTO convertToDTO(Persona persona) {
        PersonaDeportistaDTO dto = new PersonaDeportistaDTO();
        dto.setNombrePersona(persona.getNombre());
        dto.setApellido(persona.getApellido());
        dto.setNombreDeporte(persona.getDeporte().getNombre());
        return dto;
    }


}