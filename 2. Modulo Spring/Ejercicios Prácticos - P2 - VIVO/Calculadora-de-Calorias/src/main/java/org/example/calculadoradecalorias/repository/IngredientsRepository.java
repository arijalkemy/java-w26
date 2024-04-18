package org.example.calculadoradecalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.example.calculadoradecalorias.dto.IngredientDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class IngredientsRepository implements IIngredientsRepository {

    private final List<IngredientDTO> ingredientsDatabase;

    IngredientsRepository() {
        ingredientsDatabase = loadDataBase();
    }

    ;

    public IngredientDTO getIngredientByName(String name) {
        return ingredientsDatabase.stream()
                .filter(ingredientDTO -> ingredientDTO.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    private List<IngredientDTO> loadDataBase() {
        ClassPathResource classPath = new ClassPathResource("food.json");
        List<IngredientDTO> ingredientsDB = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ingredientsDB = objectMapper.readValue(classPath.getFile(), new TypeReference<>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientsDB;
    }


}
