package com.meli.calculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.calculadoracalorias.entity.Food;
import com.meli.calculadoracalorias.entity.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GetData {

    private List<Ingredient> ingredients;

    public GetData() {
        ingredients = loadDataBase();
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Ingredient> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> allIngredients = null;
        try {
            allIngredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allIngredients;
    }

    public List<Food> createFoods(){
        List<Food> foods =new ArrayList<>();
        for (int i = 0; i<=10; i++){
            List<Ingredient> ingredients = this.ingredients.subList(1,4);
            Food newFood = new Food(ingredients, "food"+ i);
            foods.add(newFood);
        }
        return  foods;
    }
}
