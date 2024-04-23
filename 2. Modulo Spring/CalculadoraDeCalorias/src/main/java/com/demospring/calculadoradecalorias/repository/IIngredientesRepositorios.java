package com.demospring.calculadoradecalorias.repository;

import com.demospring.calculadoradecalorias.dto.IngredienteDTO;

public interface IIngredientesRepositorios {
    IngredienteDTO findIngredienteByName(String name);
}
