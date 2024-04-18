package org.example.calculadoradecalorias.service;

import org.example.calculadoradecalorias.dto.DishDTO;
import org.example.calculadoradecalorias.dto.IngredientDTO;
import org.example.calculadoradecalorias.dto.ResponseDTO;
import org.example.calculadoradecalorias.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IDishesServiceImple implements IDishesService {
    @Autowired
    IngredientsRepository ingredientsRepository;

    @Override
    public ResponseDTO calculateCalories(DishDTO dish) {
        ResponseDTO responseDTO = new ResponseDTO();
        //cargo la lista de ingredientes para la response
        List<IngredientDTO> ingredients = new ArrayList<>();
        int maxCalories = 0;
        IngredientDTO highestCaloriesIngredient = null;
        int totalCalories = 0;
        for (String ingredientName : dish.getIngredients()) {
            IngredientDTO ingredient = ingredientsRepository.getIngredientByName(ingredientName);
            if (ingredient != null) {
                //totalCalories += ingredient.getCalories();
                totalCalories += dish.getWeight() * ingredient.getCalories() / 100;
                ingredients.add(ingredient);
            }
            if (ingredient != null && ingredient.getCalories() > maxCalories) {
                maxCalories = ingredient.getCalories();
                highestCaloriesIngredient = ingredient;
            }
        }
        responseDTO.setDishName(dish.getName());
        //agrego la cantidad total de calorias del plato
        responseDTO.setCaloriesQty(totalCalories);
        //agrego el ingrediente con mas calorias
        responseDTO.setHighestCaloriesIngredient(highestCaloriesIngredient);
        //agrego la lista de ingredientes a la response
        responseDTO.setIngredientsEach100Gr(ingredients);

        return responseDTO;
    }

    @Override
    public List<ResponseDTO> calculateCalories(List<DishDTO> dishes) {
        List<ResponseDTO> responseDTOs = new ArrayList<>();
        for (DishDTO dish : dishes) {
            responseDTOs.add(calculateCalories(dish));
        }
        return responseDTOs;
    }
}
