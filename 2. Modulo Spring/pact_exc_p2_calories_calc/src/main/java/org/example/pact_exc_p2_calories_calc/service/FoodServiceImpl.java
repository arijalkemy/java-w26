package org.example.pact_exc_p2_calories_calc.service;

import org.example.pact_exc_p2_calories_calc.dto.DishRequestDTO;
import org.example.pact_exc_p2_calories_calc.dto.DishResponseDTO;
import org.example.pact_exc_p2_calories_calc.dto.IngredientDTO;
import org.example.pact_exc_p2_calories_calc.entity.FoodEntity;
import org.example.pact_exc_p2_calories_calc.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements IFoodService {
    @Autowired
    IFoodRepository foodRepository;

    @Override
    public IngredientDTO getIngredientCal(String name) {
        FoodEntity foundIngredient = foodRepository.getAllFood().stream()
                .filter(ing -> ing.getName().toLowerCase().contains(name.toLowerCase()))
                .findAny()
                .orElse(null);
        IngredientDTO response = new IngredientDTO();
        if (foundIngredient != null) {
            response.setCalories(foundIngredient.getCalories());
            response.setName(foundIngredient.getName());
        }
        return response;
    }

    @Override
    public DishResponseDTO getDishCalories(DishRequestDTO dish) {
        DishResponseDTO response = new DishResponseDTO();

        int totalCal = dish.getIngredients().stream()
                .mapToInt(IngredientDTO::getCalories)
                .sum();
        IngredientDTO greatestIngredient = dish.getIngredients().stream()
                .max(Comparator.comparing(IngredientDTO::getCalories))
                .orElse(null);

        response.setTotalCalories(totalCal);
        response.setIngredients(dish.getIngredients());
        response.setGreatestCalIngredient(greatestIngredient);

        return response;
    }

    @Override
    public List<DishResponseDTO> getDishCalList(List<DishRequestDTO> dishList) {
        return dishList.stream()
                .map(this::getDishCalories)
                .collect(Collectors.toList());
    }
}
