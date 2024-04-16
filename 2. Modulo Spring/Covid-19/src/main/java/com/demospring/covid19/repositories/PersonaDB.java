package com.demospring.covid19.repositories;

import com.demospring.covid19.models.Persona;
import com.demospring.covid19.models.Sintoma;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonaDB {
    private static List<Persona> personas = new ArrayList<>();

    static {
        personas.add(new Persona(1, "Juan", "Perez", 30));
        personas.add(new Persona(2, "Maria", "Gomez", 25));
        personas.add(new Persona(3, "Pedro", "Lopez", 67));
    }

    public static List<Persona> getPersonas() {
        List<Sintoma> sintomas = SintomasDB.getSintomas();
        for (Persona persona : personas) {
            int random = new Random().nextInt(10);
            persona.setSintoma(sintomas.get(random).getCodigo());
        }
        return personas;
    }
}
