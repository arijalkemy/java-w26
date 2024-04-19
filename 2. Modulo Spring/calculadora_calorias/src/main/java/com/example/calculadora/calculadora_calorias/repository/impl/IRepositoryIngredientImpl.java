package com.example.calculadora.calculadora_calorias.repository.impl;

import com.example.calculadora.calculadora_calorias.entity.Ingredient;
import com.example.calculadora.calculadora_calorias.repository.IRepository;
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
public class IRepositoryIngredientImpl implements IRepository<Ingredient> {

    List<Ingredient> ingredientList;
    public IRepositoryIngredientImpl() {
        this.ingredientList = loadDataBase();
    }

    @Override
    public void add(Ingredient data) {

    }

    @Override
    public Optional<Ingredient> getByName(String name) {
        return null;
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientList;
    }

    private List<Ingredient> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> ingredients = null;
        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }
}
