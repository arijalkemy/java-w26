package com.spring.calorias.service;

import com.spring.calorias.dto.DishRequestDTO;
import com.spring.calorias.dto.DishResponseDTO;
import com.spring.calorias.dto.IngredientRequestDTO;
import com.spring.calorias.dto.IngredientResponseDTO;
import com.spring.calorias.entity.Ingredient;
import com.spring.calorias.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceImpl implements IDishService {

    @Autowired
    IngredientsRepository ingredientsRepository;

    @Override
    public Ingredient findIngredientByName(String name) {
        return ingredientsRepository.getIngredients()
                .stream()
                .filter(ingredient -> ingredient.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<DishResponseDTO> calculateAllDishesCalories(List<DishRequestDTO> dishesRequest) {

        List<DishResponseDTO> response = new ArrayList<>();

        for (DishRequestDTO dishRequestDTO : dishesRequest) {
            response.add(this.calculateDishCalories(dishRequestDTO));
        }
        return response;
    }

    @Override
    public DishResponseDTO calculateDishCalories(DishRequestDTO dishRequest) {

        double totalCalories = 0.0;
        IngredientResponseDTO maxIngredient = null;
        List<IngredientResponseDTO> ingredientsResponse = new ArrayList<>();

        for(IngredientRequestDTO ingredient : dishRequest.getIngredients()) {

            Ingredient ingredientFound = this.findIngredientByName(ingredient.getName());
            Double calories = (ingredient.getWeight() * ingredientFound.getCalories())/100;
            totalCalories += calories;
            IngredientResponseDTO newIngredient = new IngredientResponseDTO(
                    ingredientFound.getName(),
                    calories,
                    ingredient.getWeight()
            );

            if(maxIngredient == null || maxIngredient.getCalories() < calories) {
                maxIngredient = newIngredient;
            }

            ingredientsResponse.add(newIngredient);
        }

        return new DishResponseDTO(
                dishRequest.getName(),
                totalCalories,
                ingredientsResponse,
                maxIngredient
        );

    }

}
