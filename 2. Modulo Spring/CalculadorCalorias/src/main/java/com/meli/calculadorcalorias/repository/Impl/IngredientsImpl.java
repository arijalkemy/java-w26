package com.meli.calculadorcalorias.repository.Impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.calculadorcalorias.dto.DishReturnDTO;
import com.meli.calculadorcalorias.dto.IngredientsDTO;
import com.meli.calculadorcalorias.model.Ingredients;
import com.meli.calculadorcalorias.repository.IngredientsRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IngredientsImpl implements IngredientsRepository {


    List<DishReturnDTO> dishCreated =  new ArrayList<>();

    public IngredientsImpl() {
    }

    @Override
    public List<IngredientsDTO> searchIngredients(List<IngredientsDTO> ingredientsList) throws Error{

        List<Ingredients> ingredients = loadDataBase();

        for(IngredientsDTO ingredient : ingredientsList){
            Ingredients ingredientFound = searchIngredient(ingredient.getName());
            if(ingredientFound == null){
                throw new Error("Ingrediente no encontrado");
            }
        }

        return ingredientsList;
    }

    @Override
    public Ingredients searchIngredient(String name) throws Error {
        List<Ingredients> ingredients = loadDataBase();
        Ingredients ingredientFound = null;
        for(Ingredients ingredient : ingredients){
            ingredientFound = ingredients.stream().filter(ing -> ing.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
            if(ingredientFound == null){
                throw new Error("Ingrediente no encontrado");
            }
        }

        return ingredientFound;
    }


    @Override
    public void createDish(DishReturnDTO dish) {
        dishCreated.add(dish);
    }

    @Override
    public DishReturnDTO getDish(String name) {
        return dishCreated.stream().filter(dish -> dish.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    private List<Ingredients> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            System.err.println("Error al leer el archivo:");
            e.getCause();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredients>> typeRef = new TypeReference<>() {};
        List<Ingredients> ingredients = null;
        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo:");
            e.getCause();
        }
        return ingredients;
    }




}
