package com.example.ejercicio_arquitectura_multicapa_p1_vivo.repository;

import com.example.ejercicio_arquitectura_multicapa_p1_vivo.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    public List<Personaje> buscarPersonajesPorNombre(String name);
}
