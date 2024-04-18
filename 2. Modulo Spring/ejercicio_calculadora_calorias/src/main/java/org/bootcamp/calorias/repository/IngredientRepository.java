package org.bootcamp.calorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootcamp.calorias.model.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepository {

    private List<Ingredient> ingredientLists;

    public IngredientRepository() {
        ingredientLists = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Se carga el archivo con la lista de los personajes
            File file = ResourceUtils.getFile("classpath:food.json");
            InputStream inputStream = new FileInputStream(file);

            // Se instancia el tipo de referencia
            TypeReference<List<Ingredient>> typeReference = new TypeReference<List<Ingredient>>() {
            };

            // Se realiza el mapeo del json a la lista
            ingredientLists = objectMapper.readValue(inputStream, typeReference);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Ingredient> findAll(){
        return ingredientLists;
    }

}
