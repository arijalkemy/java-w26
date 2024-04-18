package org.example.calculadoradecalorias.repository;

import org.example.calculadoradecalorias.dto.IngredientDTO;

public interface IIngredientsRepository {
    IngredientDTO getIngredientByName(String name);
}
