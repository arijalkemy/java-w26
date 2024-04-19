package com.bootcamp.food.service.implementations;

import com.bootcamp.food.dto.DishResponseDTO;
import com.bootcamp.food.dto.IngredientResponseDTO;
import com.bootcamp.food.entities.Dish;
import com.bootcamp.food.entities.Ingredient;
import com.bootcamp.food.repository.IDishesRepository;
import com.bootcamp.food.service.IDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DishesServiceImpl implements IDishesService {
    @Autowired
    IDishesRepository iDishesRepository;

    @Override
    public DishResponseDTO searchDishByNameAndWeight(String name, Double weight) {
         List<Dish> allDishes = iDishesRepository.findAll();
         Optional<Dish> dish = allDishes.
                 stream().
                 filter(d -> d.getName().equals(name) && d.getWeight().equals(weight)).
                 findFirst();

         if (dish.isPresent()) {
            return mapDishToDTO(dish.get());
         }

         return null;
    }

    public static DishResponseDTO mapDishToDTO(Dish dish) {
        List<Ingredient> dishIngredients = dish.getIngredients();
        List<IngredientResponseDTO> ingredientResponseDTOS = new ArrayList<>();
        for (Ingredient ingredient : dishIngredients) {
            ingredientResponseDTOS.add(mapIngredientToDTO(ingredient));
        }

        String mostCaloriesIngredient = dishIngredients.
                stream().sorted(Comparator.comparing(Ingredient::getCalories)).findFirst().get().getName();

        return new DishResponseDTO(
                dish.getName(),
                dish.getWeight(),
                ingredientResponseDTOS,
                mostCaloriesIngredient

        );
    }

    public static IngredientResponseDTO mapIngredientToDTO(Ingredient ingredient) {
        System.out.println("INGREDIENTE: "+ingredient.getName()+ingredient.getCalories());
        return new IngredientResponseDTO(
                ingredient.getName(),
                ingredient.getCalories()
        );
    }
}
