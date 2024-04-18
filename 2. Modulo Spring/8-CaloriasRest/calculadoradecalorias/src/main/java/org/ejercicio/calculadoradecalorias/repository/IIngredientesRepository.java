package org.ejercicio.calculadoradecalorias.repository;

import org.ejercicio.calculadoradecalorias.entity.Ingrediente;

import java.util.List;

public interface IIngredientesRepository {
    List<Ingrediente> buscarTodos();
    Ingrediente buscarPorNombre(String nombre);
}
