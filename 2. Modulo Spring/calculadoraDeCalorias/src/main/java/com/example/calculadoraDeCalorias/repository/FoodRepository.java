package com.example.calculadoraDeCalorias.repository;

import com.example.calculadoraDeCalorias.model.Food;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class FoodRepository {

    private List<Food> foods = new ArrayList<>();

    public void populate(){
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            JsonNode jsonNode = objectMapper.readTree(new ClassPathResource("data/foods.json").getFile());
            for(JsonNode object: jsonNode){
                String name = object.get("name").asText();
                Integer weight = object.get("weight").asInt();
                JsonNode ingredientsjson = object.get("ingredients");
                List<String> ingredients = new ArrayList<>();
                Iterator<JsonNode> elements = ingredientsjson.elements();
                while(elements.hasNext()){
                    JsonNode element = elements.next();
                    ingredients.add(element.asText());
                }
                this.foods.add(new Food(name, weight, ingredients));
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public List<Food> findAll(){
        populate();
        return this.foods;
    }

    public Food findByName(String name){
        populate();
        return this.foods.stream().filter(nameFood -> nameFood.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

}
