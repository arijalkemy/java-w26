package com.CalculadoraDeCalorias.CalculadoraDeCalorias.repository.interfaces;

import com.CalculadoraDeCalorias.CalculadoraDeCalorias.entity.Plato;

import java.util.List;

public interface IPlatoRepository {
    public List<Plato> obtenerPlatos();
}
