package org.bootcamp.calorias.service;

import org.bootcamp.calorias.dto.IngredientDTO;
import org.bootcamp.calorias.model.Ingredient;

import java.util.List;

public interface IngredientService {

    List<IngredientDTO> getAll();

    IngredientDTO getHighest(List<Ingredient> ingredients);

}
