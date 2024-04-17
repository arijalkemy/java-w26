package com.meli.calculadoraDeCalorias.service;

import com.meli.calculadoraDeCalorias.dto.DishInputDTO;
import com.meli.calculadoraDeCalorias.dto.DishResponseDTO;
import com.meli.calculadoraDeCalorias.model.Dish;
import com.meli.calculadoraDeCalorias.model.Ingredient;
import com.meli.calculadoraDeCalorias.repository.IDishRepository;
import com.meli.calculadoraDeCalorias.repository.IIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceImpl implements IDishService {

    @Autowired
    private IDishRepository dishRepository;

    @Autowired
    private IIngredientRepository ingredientRepository;

    @Override
    public DishResponseDTO getDishInfo(String name, double weight) {
        Dish dish = dishRepository.getByNameAndWeight(name, weight);
        return buildDishResponseDto(dish);
    }

    @Override
    public void saveDish(DishInputDTO dishInput){
        List<Ingredient> ingredients = new ArrayList<>();

        for(String d: dishInput.getIngredientName()){
            ingredients.add(ingredientRepository.getByName(d));
        }

        Dish dish = new Dish(dishInput.getName(), ingredients, dishInput.getWeight());
        dishRepository.saveDish(dish);
    }

    private DishResponseDTO buildDishResponseDto(Dish dish){
        return new DishResponseDTO(dish.totalCalories(), dish.getIngredientList(),
                dish.mostCaloricIngredient());
    }
}
