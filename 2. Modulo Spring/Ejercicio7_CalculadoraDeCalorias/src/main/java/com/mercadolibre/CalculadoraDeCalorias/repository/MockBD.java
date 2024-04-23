package com.mercadolibre.CalculadoraDeCalorias.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.CalculadoraDeCalorias.entity.Dish;
import com.mercadolibre.CalculadoraDeCalorias.entity.Ingredient;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MockBD {
    private List<Ingredient> ingredients;
    private List<Dish> dishes;

    public MockBD(){
        this.ingredients = this.loadIngredientsDatabase();
        this.dishes = this.loadDishes();
    }

    private List<Ingredient> loadIngredientsDatabase() {
        List<Ingredient> ingredients = new ArrayList<>();
        String rutaArchivo = "classpath:food.json";
        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile(rutaArchivo);
            List<Map<String, Object>> datos = objectMapper.readValue(file, List.class);

            for (Map<String, Object> dato : datos) {
                Ingredient ingredient = new Ingredient();
                ingredient.setName((String) dato.get("name"));
                ingredient.setCalorie((int) dato.get("calories"));
                ingredients.add(ingredient);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    private List<Dish> loadDishes(){
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("EnsaladaMediterránea",List.of(this.searchIngredient("Tomate"),
                this.searchIngredient("Aceitunas negras"),
                this.searchIngredient("Lechuga"),
                this.searchIngredient("Aceite de oliva"))));
        dishes.add(new Dish("PastaPrimavera",List.of(this.searchIngredient("Pasta de sémola"),
                this.searchIngredient("Brócoli"),
                this.searchIngredient("Pimiento"),
                this.searchIngredient("Espinaca"))));
        dishes.add(new Dish("ArrozconChampiñones",List.of(this.searchIngredient("Arroz blanco"),
                this.searchIngredient("Champiñón y otras setas"),
                this.searchIngredient("Cebolla"),
                this.searchIngredient("Aceite de oliva"))));
        return  dishes;
    }

    public Ingredient searchIngredient(String name){
        for (Ingredient i : this.ingredients){
            if (i.getName().contains(name))
                return i;
        }
        return null;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

}

