package com.CalculadoraDeCalorias.CalculadoraDeCalorias.repository.interfaces;

import com.CalculadoraDeCalorias.CalculadoraDeCalorias.entity.Ingredientes;

import java.util.List;

public interface IIngredientesRepository {
    public List<Ingredientes> obtenerListaIngredientes();
}
