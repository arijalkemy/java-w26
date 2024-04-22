package org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.repository;

import org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.entities.Persona;

import java.util.List;

public interface IPersonaRepository {
    public List<Persona> obtenerPersonas();
}
