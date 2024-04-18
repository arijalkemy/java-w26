package org.example.ejerciciocalculadoracalorias.service.impl;

import org.example.ejerciciocalculadoracalorias.dto.DishDTO;
import org.example.ejerciciocalculadoracalorias.dto.IngredientsDTO;
import org.example.ejerciciocalculadoracalorias.entity.Dish;
import org.example.ejerciciocalculadoracalorias.entity.Ingredients;
import org.example.ejerciciocalculadoracalorias.repository.MenuRepository;
import org.example.ejerciciocalculadoracalorias.service.IDish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishImpl implements IDish {

    private MenuRepository dishList = new MenuRepository();

    @Override
    public Double calculateTotalDishCalories(String nameDish) {
        Dish dish = dishList.findOne(nameDish);
        Double totalCalories = 0.0;
        Double calorieFactor = ((double) dish.getWeight())/100;
        for(Ingredients i: dish.getIngredientsList()){
            totalCalories = totalCalories + (((double) i.getCalories())*calorieFactor);
        }
        return totalCalories;
    }

    @Override
    public List<IngredientsDTO> searchTotalIngredients(String nameDish) {
        Dish dish = dishList.findOne(nameDish);
        List<IngredientsDTO> result = new ArrayList<>();
        Double calorieFactor = ((double) dish.getWeight())/100;
        for(Ingredients i:  dish.getIngredientsList()){
            result.add(new IngredientsDTO(i.getName(),(((double) i.getCalories())*calorieFactor)));
        }
        return result;
    }

    @Override
    public IngredientsDTO searchMostCaloriesIngredients(String nameDish) {
        Dish dish = dishList.findOne(nameDish);
        IngredientsDTO ingredient = new IngredientsDTO("", 0.0);
        Double calorieFactor = ((double) dish.getWeight())/100;
        for(Ingredients i: dish.getIngredientsList()){
            if(ingredient.getCalories()<((double) i.getCalories())){
                ingredient = new IngredientsDTO(i.getName(),(((double) i.getCalories())*calorieFactor));
            }
        }
        return ingredient;
    }

    @Override
    public List<DishDTO> searchAllDishes() {
        List<DishDTO> result = new ArrayList<>();
        for(Dish d: dishList.findAll()){
            result.add(new DishDTO(d.getName(), d.getWeight(), searchTotalIngredients(d.getName())));
        }
        return result;
    }
}
