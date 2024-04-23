package com.mercadolibre.CalculadoraDeCalorias.service.implement;

import com.mercadolibre.CalculadoraDeCalorias.dto.DishDTO;
import com.mercadolibre.CalculadoraDeCalorias.entity.Dish;
import com.mercadolibre.CalculadoraDeCalorias.entity.Ingredient;
import com.mercadolibre.CalculadoraDeCalorias.repository.MockBD;
import com.mercadolibre.CalculadoraDeCalorias.service.IDishService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DishServiceImpl implements IDishService {
    @Override
    public DishDTO findDish(String name) {
        MockBD bd = new MockBD();
        List<Dish> dishes = bd.getDishes();
        Dish dish = dishes.stream().filter(dish1 -> this.matchWitch(name,dish1)).findFirst().orElse(null);
        DishDTO dishDTO = new DishDTO(dish.getName(),dish.getListIngredients(),
                this.highestCalorieIngredient(dish.getListIngredients()),
                this.totalCaloriesDish(dish.getListIngredients()));
        return dishDTO;
    }

    public String highestCalorieIngredient(List<Ingredient> ingredients){
        Ingredient ingredient = ingredients.stream().sorted(Comparator.comparingDouble(Ingredient::getCalorie).reversed()).findFirst().orElse(null);
        if (ingredient==null) return null;
        return ingredient.getName();
    }

    public double totalCaloriesDish(List<Ingredient> ingredients){
        return ingredients.stream().map(i -> i.getCalorie()).mapToDouble(Integer::intValue).sum();
    }

    public boolean matchWitch(String name, Dish dish){
        if (dish.getName().toUpperCase().equals(name.toUpperCase()))
            return true;
        return false;
    }
}
