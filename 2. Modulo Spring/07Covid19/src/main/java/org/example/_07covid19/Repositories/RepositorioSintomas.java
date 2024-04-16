package org.example._07covid19.Repositories;

import org.example._07covid19.Persona;
import org.example._07covid19.Sintoma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class RepositorioSintomas {
    private static HashMap<String, Sintoma> sintomas = new HashMap<String, Sintoma>();
    private static HashMap<String, Persona> personas = new HashMap<String, Persona>();

    public static void guardar(Sintoma sintoma) {
        sintomas.put(sintoma.getNombre(), sintoma);
    }

    public static void guardar(Persona persona) {
        personas.put(persona.getId(), persona);
    }

    public static List<Persona> obtenerPersonas() {
        return personas.values().stream().toList();
    }

    public static Sintoma obtenerPorNombre(String nombre) {
        return sintomas.get(nombre);
    }

    public static List<Sintoma> obtenerTodos() {
        return sintomas.values().stream().toList();
    }
}
