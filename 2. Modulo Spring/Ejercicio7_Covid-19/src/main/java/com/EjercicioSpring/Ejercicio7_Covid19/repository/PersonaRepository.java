package com.EjercicioSpring.Ejercicio7_Covid19.repository;

import com.EjercicioSpring.Ejercicio7_Covid19.entity.Persona;

import java.util.List;

public class PersonaRepository implements ICRUD<Persona> {
    @Override
    public void create(Persona persona) {

    }

    @Override
    public List<Persona> getAll() {
        return baseDeDatos.getPersonas();
    }
}
