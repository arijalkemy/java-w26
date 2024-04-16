package com.example.deportistas.service;

import com.example.deportistas.DTO.DeportistaDTO;
import com.example.deportistas.model.Deporte;
import com.example.deportistas.model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService implements IPersonaService{
    static Deporte dep1 = new Deporte("futbol", 5);
    static Deporte dep2 = new Deporte("tenis", 3);
    static Deporte dep3 = new Deporte("basket", 2);
    static Deporte dep4 = new Deporte("voley", 4);
    static Deporte dep5 = new Deporte("ajedrez", 2);
    private static List<Persona> personas = new ArrayList<>();
    static {personas.add(new Persona("juan","perez", 20, dep1));
        personas.add(new Persona("pedro","sosa", 21, dep2));
        personas.add(new Persona("lucas","martinez", 25, dep3));
        personas.add(new Persona("mariano","paez", 19, dep4));
        personas.add(new Persona("cristian","peralta", 23, dep5));
    }

    @Override
    public List<DeportistaDTO> verDeportistas() {
        List<DeportistaDTO> deportistas = new ArrayList<>();
        personas.stream()
                .forEach(persona -> deportistas.add(
                        new DeportistaDTO(persona.getNombre(),
                        persona.getApellido(),
                        persona.getDeporte().getNombre())));
        return deportistas;
    }
}
