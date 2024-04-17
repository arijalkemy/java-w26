package com.example.deportista.dto;

import com.example.deportista.repository.PersonaRepository;

import java.io.Serializable;
import java.util.List;


public class PersonaDTO implements Serializable {
    private String nombre;
    private String apellido;
    private String deporte;

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDeporte() {
        return deporte;
    }

    public static List<PersonaDTO> getPersonas() {
        return PersonaRepository.getPersonas().stream()
                .map(persona -> new PersonaDTO(
                        persona.getNombre(),
                        persona.getApellido(),
                        persona.getDeporte().getNombre()
                )).toList();
    }

    public PersonaDTO(String nombre, String apellido, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
    }
}
