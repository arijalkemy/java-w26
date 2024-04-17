package org.bootcamp.ejercicios_practicos_calculadora_de_calorias.service.impl;

import org.bootcamp.ejercicios_practicos_calculadora_de_calorias.dto.DishDTO;
import org.bootcamp.ejercicios_practicos_calculadora_de_calorias.entity.Ingredient;
import org.bootcamp.ejercicios_practicos_calculadora_de_calorias.service.IFoodRepositoryService;
import org.bootcamp.ejercicios_practicos_calculadora_de_calorias.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class FoodServiceImpl implements IFoodService {
    @Autowired
    private IFoodRepositoryService foodRepositoryService;

    @Override
    public int getCalories(DishDTO dish) {
        List<Ingredient> ingredients = foodRepositoryService.getAllIngredients();
        List<Optional<Ingredient>> dishIngredients = new ArrayList<>();

        for (Ingredient ingredient : dish.getIngredients()) {
                ingredients
                    .stream()
                    .filter(ing -> ing.getName().equals(ingredient.getName()))
                    .findFirst();
        }

        return 0;
    }
}
