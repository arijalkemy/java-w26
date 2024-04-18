package org.example.ejerciciocalculadoracalorias.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ejerciciocalculadoracalorias.entity.Ingredients;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IngredientsRepository implements IIngredientsRepository{

    public List<Ingredients> ingredients = null;

    @Override
    public List<Ingredients> findAllIngredients() {
        if(ingredients == null){
            fillIngredientsRepository();
        }
        return ingredients;
    }

    @Override
    public Ingredients findOne(String name) {
        if(ingredients == null){
            fillIngredientsRepository();
        }
        List<Ingredients> listIngredientesFilter = ingredients.stream().filter(i -> i.getName().equals(name)).toList();
        return listIngredientesFilter.get(0);
    }

    public void fillIngredientsRepository(){
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get("src/main/resources/static/food.json")));
            ObjectMapper objectMapper = new ObjectMapper();
            ingredients = objectMapper.readValue(jsonContent, objectMapper.getTypeFactory().constructCollectionType(List.class, Ingredients.class));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
