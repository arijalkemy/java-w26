package com.EjercicioDeportista.EjercicioDeportista.services;

import com.EjercicioDeportista.EjercicioDeportista.clases.Deporte;

import java.util.Optional;

public interface IDeporteService {
    public Optional<Deporte> findSportsName(String name);
}
