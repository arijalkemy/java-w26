package com.example.deportista.service;


import com.example.deportista.entities.Deporte;

import java.util.List;

public interface IDeporteService {

    List<Deporte> ObtenerDeportes();
    Deporte obtenerDeportePorNombre(String nombre);

}
