package com.example.EjercicioDeporte.repository;


import com.example.EjercicioDeporte.model.Deporte;
import com.example.EjercicioDeporte.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    public static List<Deporte> deportes;
    public static List<Persona> personas;

    static {
        // Agregar síntomas hardcodeados
        deportes = new ArrayList<>();
        deportes.add(new Deporte("Futbol", "Alto"));
        deportes.add(new Deporte("Rugby", "Medio"));
        deportes.add(new Deporte("Tennis", "Bajo"));

        // Agregar personas hardcodeadas
        personas = new ArrayList<>();
        personas.add(new Persona("Juan", "Perez", 30, deportes.get(0)));
        personas.add(new Persona("María", "González", 30, deportes.get(2)));
        personas.add(new Persona("Carlos", "López", 30, null));
        personas.add(new Persona("Ana", "Martínez", 30, deportes.get(1)));
    }

}
