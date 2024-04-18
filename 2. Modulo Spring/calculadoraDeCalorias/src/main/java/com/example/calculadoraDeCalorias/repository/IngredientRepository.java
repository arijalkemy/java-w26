package com.example.calculadoraDeCalorias.repository;

import com.example.calculadoraDeCalorias.model.Ingredient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepository {

    private List<Ingredient> ingredients = new ArrayList<>();

    public void populate(){
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            JsonNode jsonNode = objectMapper.readTree(new ClassPathResource("data/ingredients.json").getFile());
            for(JsonNode object: jsonNode){
                String name = object.get("name").asText();
                Integer calories = object.get("calories").asInt();
                this.ingredients.add(new Ingredient(name, calories));
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public List<Ingredient> findAll(){
        populate();
        return this.ingredients;
    }


}
