package co.com.mercadolibre.calorias.repository.impl;

import co.com.mercadolibre.calorias.entity.Ingredient;
import co.com.mercadolibre.calorias.repository.IIngredientRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IngredientRepository implements IIngredientRepository {

    @Override
    public Ingredient findIngredientByName(String name) {
        for (Ingredient ingredient: this.listAll()) {
            if (ingredient.getName().toLowerCase().equals(name.toLowerCase())) {
                return ingredient;
            }
        }
        return null;
    }

    private List<Ingredient> listAll() {
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get("src/main/resources/food.json")));
            ObjectMapper objectMapper = new ObjectMapper();
            List<Ingredient> ingredients = objectMapper.readValue(jsonContent,
                    new TypeReference<List<Ingredient>>() {});
            return ingredients;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
