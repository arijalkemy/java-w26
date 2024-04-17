package com.javabootcamp.covid19.service;

import com.javabootcamp.covid19.dto.Persona;
import com.javabootcamp.covid19.dto.Sintoma;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CovidService {

    // Crear una lista de sintomas y una lista de personas
    List<Sintoma> sintomas = List.of(
        new Sintoma(1, "Fiebre", 5),
        new Sintoma(2, "Tos seca", 4),
        new Sintoma(3, "Cansancio", 3),
        new Sintoma(4, "Dolor de garganta", 2),
        new Sintoma(5, "Diarrea", 1)
    );

    List<Persona> personas = List.of(
        new Persona(1, "Juan", "Perez", 25,sintomas.get(0)),
        new Persona(2, "Maria", "Gomez", 30,sintomas.get(2)),
        new Persona(3, "Pedro", "Lopez", 40,sintomas.get(4)),
        new Persona(4, "Ana", "Martinez", 50,sintomas.get(1)),
        new Persona(5, "Luis", "Rodriguez", 60,sintomas.get(0))
    );

    public List<Sintoma> getAllSintomas() {
        return sintomas.stream().toList();
    }

    public Sintoma findSymptom(String name){
        for(Sintoma p:sintomas){
            if(p.getNombre().equals(name)){
                return p;
            }
        }
        return null;
    }


    public List<Persona> getAllPersonas() {
        return personas.stream().toList();
    }
}


