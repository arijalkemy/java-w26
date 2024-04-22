package org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.services.impl;

import org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.entities.Deporte;
import org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.repository.IDeporteRepository;
import org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.services.IDeporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeporteServiceImpl implements IDeporte {
    @Autowired
    IDeporteRepository deporteRepository;

    @Override
    public List<Deporte> encontrarDeportes() {
        return deporteRepository.obtenerDeportes();
    }

    @Override
    public int encontrarDeporte(String nombre) {
        return deporteRepository.obtenerDeportes()
                .stream()
                .filter(deporte -> deporte.getNombre().equals(nombre))
                .findFirst()
                .get()
                .getNivel();
    }
}
