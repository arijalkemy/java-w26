package org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.repository;

import org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.entities.Deporte;

import java.util.List;

public interface IDeporteRepository {
    public List<Deporte> obtenerDeportes();
}
