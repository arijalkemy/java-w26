package org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.repository;

import org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.entities.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepository implements IPersonaRepository{
    private List<Persona> listaPersonas = new ArrayList<>();

    public PersonaRepository() {
        listaPersonas = llenarListaPersonas();
    }

    @Override
    public List<Persona> obtenerPersonas() {
        return listaPersonas;
    }

    private List<Persona> llenarListaPersonas() {
        List<Persona> personas = new ArrayList<>();

        personas.add(new Persona("Pedro", "Arriaga", 27));
        personas.add(new Persona("Manuel", "Malacara", 24));
        personas.add(new Persona("Yair", "Valderrama", 27));
        personas.add(new Persona("Jonathan", "Pérez", 24));

        return personas;
    }
}
