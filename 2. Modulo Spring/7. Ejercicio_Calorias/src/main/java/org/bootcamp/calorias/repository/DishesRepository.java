package org.bootcamp.calorias.repository;

import lombok.Getter;
import org.bootcamp.calorias.dto.DishDTO;
import org.bootcamp.calorias.dto.IngredientDTO;
import org.bootcamp.calorias.model.Dish;
import org.bootcamp.calorias.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Getter
@Repository
public class DishesRepository {
    private final List<Dish> dishes;

    public DishesRepository() {
        dishes = loadDishes();
    }

    private List<Dish> loadDishes() {
        return List.of(
            new Dish("Hamburger", List.of(
                new Ingredient("Bread", 100),
                new Ingredient("Meat", 200),
                new Ingredient("Cheese", 100),
                new Ingredient("Ketchup", 50)
            )),
            new Dish("Pizza", List.of(
                new Ingredient("Dough", 300),
                new Ingredient("Cheese", 200),
                new Ingredient("Tomato", 100),
                new Ingredient("Ham", 150)
            )),
            new Dish("Sushi", List.of(
                new Ingredient("Rice", 300),
                new Ingredient("Salmon", 200),
                new Ingredient("Seaweed", 100)
            ))
        );
    }

    public DishDTO calculateDishCalories(String name, int weight) {
        Dish dish = dishes.stream()
            .filter(d -> d.getName().equals(name))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Dish not found"));

        int totalCalories = 0;
        Ingredient mostCaloricIngredient = null;

        for (Ingredient ingredient : dish.getIngredients()) {
            totalCalories += ingredient.getCalories() * weight / 100;
            if (mostCaloricIngredient == null || ingredient.getCalories() > mostCaloricIngredient.getCalories()) {
                mostCaloricIngredient = ingredient;
            }
        }

        return new DishDTO(name, totalCalories, dish.getIngredients().stream()
            .map(i -> new IngredientDTO(i.getName(), i.getCalories() * weight / 100))
            .toList(), new IngredientDTO(mostCaloricIngredient.getName(), mostCaloricIngredient.getCalories() * weight / 100));
    }
}