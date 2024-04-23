package com.mercadolibre.caloriecalculator.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.caloriecalculator.entity.Ingredient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepository {
    private List<Ingredient> ingredients;
    public IngredientRepository() {
        this.ingredients = readIngredientJson();
    }
    public List<Ingredient> findAll() {
        return ingredients;
    }
    private List<Ingredient> readIngredientJson() {
        File file = null;
        try {
            ClassPathResource classPathResource = new ClassPathResource("ingredients.json");
            file = classPathResource.getFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        try {
            return objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }


}
