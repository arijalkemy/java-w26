package org.example.calories.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.example.calories.entities.Food;
import org.example.calories.entities.Ingredient;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Getter
@Repository
public class IngredientRepository {
    private List<Ingredient> ingredients;

    public IngredientRepository() {
        try {
            Resource resource = new ClassPathResource("static/food.json");
            InputStream input = resource.getInputStream();
            File file = resource.getFile();
            ObjectMapper objectMapper = new ObjectMapper();
            this.ingredients = Arrays.asList(objectMapper.readValue(file, Ingredient[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
