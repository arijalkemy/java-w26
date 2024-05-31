package com.melibootcamp.calories.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.melibootcamp.calories.entity.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class IngredientsRepository implements IIngredients{
    private List<Ingredient> ingredientList;

    public IngredientsRepository() {
        this.ingredientList = cargarDatabase();
    }

    private List<Ingredient> cargarDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {
        };
        List<Ingredient> ingredients = new ArrayList<>();
        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Ingredientes cargados: "+ingredients.size());
        return ingredients;

    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientList;
    }
}
