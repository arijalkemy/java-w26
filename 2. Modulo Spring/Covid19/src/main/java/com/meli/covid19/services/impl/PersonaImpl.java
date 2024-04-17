package com.meli.covid19.services.impl;

import com.meli.covid19.dto.PersonaDTO;
import com.meli.covid19.dto.SintomaDTO;
import com.meli.covid19.services.IPersona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaImpl implements IPersona {

    private static List<SintomaDTO> sintomas = new ArrayList<>();
    static {
        sintomas.add(new SintomaDTO(1,"Fiebre","Alto"));
        sintomas.add(new SintomaDTO(2,"Tos","Alto"));
        sintomas.add(new SintomaDTO(3,"Dolor de garganta","Medio"));
        sintomas.add(new SintomaDTO(4,"Perdida del gusto","Alto"));
        sintomas.add(new SintomaDTO(5,"Congestion nasal","Bajo"));
        sintomas.add(new SintomaDTO(6,"Dificultad para respirar","Alto"));
    }
    public static List<PersonaDTO> personas = new ArrayList<>();
    static {
        personas.add(new PersonaDTO(1,"Ana","Torres",62));
        personas.add(new PersonaDTO(2,"Juan","Gomez",63, sintomas.stream().filter(s->s.getNombre().equals("Fiebre")).toList()));
        personas.add(new PersonaDTO(2,"Cecilia","Lopez",45, sintomas.stream().filter(s->s.getNombre().equals("Perdida del gusto")).toList()));
        personas.add(new PersonaDTO(2,"Anita","Taylor",65, sintomas.stream().filter(s->s.getNombre().equals("Dificultad para respirar")).toList()));
    }

    @Override
    public List<PersonaDTO> personasEnRiesgo() {
        return personas.stream().filter(p->p.obtenerRiesgo().equals("Alto")).toList();
    }
}
