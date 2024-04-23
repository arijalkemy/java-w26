package com.mercadolibre.DeportistasAPI.services;

import com.mercadolibre.DeportistasAPI.model.Deporte;

import java.util.List;

public interface IDeportistaService {

    public List<Deporte> obtDeportes();
    public String obtDeportePorNombre(String nombre);

}
