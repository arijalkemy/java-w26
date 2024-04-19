package com.bootcamp.food.repository.implementations;

import com.bootcamp.food.FoodApplication;
import com.bootcamp.food.entities.Dish;
import com.bootcamp.food.entities.Ingredient;
import com.bootcamp.food.repository.IDishesRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DishesRepositoryImpl implements IDishesRepository {
    private List<Ingredient> ingredients;

    private List<Dish> dishes;

    public DishesRepositoryImpl() {
        readJSON();
        createDishes();
    }

    private void readJSON() {
        try {
            this.ingredients = new ArrayList<>();
            this.dishes = new ArrayList<>();
            String pathJsonFood = "src/main/resources/foods.json";
            ObjectMapper mapper = new ObjectMapper();
            List<Ingredient> ingredientesJson = mapper.readValue(new File(pathJsonFood), new TypeReference<List<Ingredient>>() {});
            this.ingredients = ingredientesJson;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void createDishes () {
        this.dishes.add(new Dish("Pizza", 15.5, this.ingredients.subList(1,10)));
        this.dishes.add(new Dish("Ensalada", 17.8, this.ingredients.subList(15,20)));
        this.dishes.add(new Dish("Pasta", 20.0, this.ingredients.subList(20,25)));
    }

    @Override
    public List<Dish> findAll() {
        return this.dishes;
    }
}
