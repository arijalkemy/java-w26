package com.CalculadoraDeCalorias.CalculadoraDeCalorias.repository;

import com.CalculadoraDeCalorias.CalculadoraDeCalorias.entity.Ingredientes;
import com.CalculadoraDeCalorias.CalculadoraDeCalorias.repository.interfaces.IIngredientesRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


@Repository
public class IngredientesRepositoryImpl implements IIngredientesRepository {
    public IngredientesRepositoryImpl() {
    }

    @Override
    public List<Ingredientes> obtenerListaIngredientes() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredientes>> typeRef = new TypeReference<>() {
        };
        List<Ingredientes> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
