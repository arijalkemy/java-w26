package com.spring.calorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.calorias.entity.Ingredient;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class IngredientsRepository {

    private List<Ingredient> ingredients;

    public IngredientsRepository() {
       this.ingredients = loadJSONData();
    }

    private List<Ingredient> loadJSONData(){
        try{
            File file = ResourceUtils.getFile("classpath:food.json");
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(
                    file, new TypeReference<List<Ingredient>>(){}
            );
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error en el manejo del archivo: " + e.getMessage());
        }
        return new ArrayList<>();
    }

}
