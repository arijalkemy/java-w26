package com.ejercicio.calculadoradecalorias.repository.implementations;

import com.ejercicio.calculadoradecalorias.entity.Ingredient;
import com.ejercicio.calculadoradecalorias.repository.interfaces.IRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepository implements IRepository<Ingredient> {
    private List<Ingredient> ingredientList;

    public IngredientRepository() {
        loadDataBase();
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientList;
    }

    @Override
    public Ingredient getByName(String name) {
        Optional<Ingredient> result = ingredientList
                .stream()
                .filter(ingredient -> ingredient.getName().equals(name))
                .findFirst();

        if (result.isPresent()) return result.get();
        return null;
    }

    private void loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("src/main/resources/food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        try {
            ingredientList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
