package com.bootcamp.c3calculadoracalorias.repository;

import com.bootcamp.c3calculadoracalorias.model.Ingrediente;

public interface IngredienteRepository {
    Ingrediente encontrarIngrediente(String nombre);
}
