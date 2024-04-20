package com.meli.calculadorcalorias.service.Impl;

import com.meli.calculadorcalorias.dto.DishDTO;
import com.meli.calculadorcalorias.dto.DishReturnDTO;
import com.meli.calculadorcalorias.dto.IngredientsDTO;
import com.meli.calculadorcalorias.dto.IngredientsReturnDTO;
import com.meli.calculadorcalorias.model.Ingredients;
import com.meli.calculadorcalorias.repository.IngredientsRepository;
import com.meli.calculadorcalorias.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientsSImpl implements IngredientsService {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    public IngredientsSImpl(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }



    @Override
    public double calculateCalories(List<IngredientsReturnDTO> ingredients) {
        return ingredients.stream().mapToDouble(IngredientsReturnDTO::getTotalCalories).sum();
    }


    @Override
    public List<IngredientsReturnDTO> ReMapIngredints(List<IngredientsDTO> list) {
        List<IngredientsReturnDTO> ingredientsReturnDTOS = new ArrayList<>();
        for (IngredientsDTO ingredientsDTO : list) {
            Ingredients ingredients = ingredientsRepository.searchIngredient(ingredientsDTO.getName());
            if (ingredients != null) {
                double caloriesPer100Grams = (ingredients.getCalories() * ingredientsDTO.getWeight()) / 100;
                ingredientsReturnDTOS.add(new IngredientsReturnDTO(ingredients.getName(), ingredients.getCalories(), ingredientsDTO.getWeight(), caloriesPer100Grams));
            }
        }
        return ingredientsReturnDTOS;
    }

    @Override
    public DishReturnDTO ReturnDish(DishDTO dish) {
        List<IngredientsReturnDTO> ingredientsReturnDTOS = ReMapIngredints(dish.getIngredients());
        double totalCalories = calculateCalories(ingredientsReturnDTOS);
        DishReturnDTO dishCreated = new DishReturnDTO(dish.getName(), ingredientsReturnDTOS, totalCalories);
        saveDish(dishCreated);
        return dishCreated;
    }


    @Override
    public void saveDish(DishReturnDTO dish)
    {
        ingredientsRepository.createDish(dish);
    }


    @Override
    public DishReturnDTO getDish(String name)
    {
        return ingredientsRepository.getDish(name);
    }

}
