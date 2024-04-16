package com.example._04_deportista.servicios;

import com.example._04_deportista.model.Deporte;

import java.util.List;

public interface IDeporteService {
    public List<Deporte> obtenerDeportes();
    public int obtenerNivelDeDeporte(String nombre);

}
