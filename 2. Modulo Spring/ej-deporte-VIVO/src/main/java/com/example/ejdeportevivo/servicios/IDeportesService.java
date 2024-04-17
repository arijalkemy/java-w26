package com.example.ejdeportevivo.servicios;

import com.example.ejdeportevivo.modelo.Deporte;

import java.util.List;
import java.util.Optional;

public interface IDeportesService {

    public List<Deporte> obtenerTodosLosDeportes();
    public Optional<Deporte> obtenerDeportePorNombre(String nombre);

}
