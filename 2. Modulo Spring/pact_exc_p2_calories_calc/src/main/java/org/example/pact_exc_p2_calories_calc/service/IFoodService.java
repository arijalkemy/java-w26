package org.example.pact_exc_p2_calories_calc.service;

import org.example.pact_exc_p2_calories_calc.dto.DishRequestDTO;
import org.example.pact_exc_p2_calories_calc.dto.DishResponseDTO;
import org.example.pact_exc_p2_calories_calc.dto.IngredientDTO;

import java.util.List;

public interface IFoodService {
    public IngredientDTO getIngredientCal(String name);
    public DishResponseDTO getDishCalories(DishRequestDTO dish);
    public List<DishResponseDTO> getDishCalList(List<DishRequestDTO> dishList);
}
