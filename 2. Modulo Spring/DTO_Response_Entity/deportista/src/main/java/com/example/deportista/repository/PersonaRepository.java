package com.example.deportista.repository;

import com.example.deportista.model.Deporte;
import com.example.deportista.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepository {
    private static List<Persona> personas = new ArrayList<>(){{
        Deporte futbol = new Deporte("futbol","profesional");
        add(new Persona("Juan","Lopez",27,
                DeporteRepository.getDeportes().get(0)
        ));
    }};
    public static List<Persona> getPersonas(){
        return personas;
    }
    public static void addPersona(Persona persona){
        personas.add(persona);
    }
}
