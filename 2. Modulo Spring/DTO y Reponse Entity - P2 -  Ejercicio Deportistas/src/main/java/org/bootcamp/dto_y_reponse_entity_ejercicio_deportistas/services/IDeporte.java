package org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.services;

import org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.entities.Deporte;

import java.util.List;

public interface IDeporte {
    public List<Deporte> encontrarDeportes();
    public int encontrarDeporte(String nombre);
}
