package org.mercadolibre.multicapatemplate.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mercadolibre.multicapatemplate.entity.Ingredient;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class IngredientRepository {

    private List<Ingredient> ingredientList;

    public IngredientRepository(ResourceLoader resourceLoader) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = resourceLoader.getResource("classpath:static/ingredients.json");
        this.ingredientList = objectMapper.readValue(
                resource.getInputStream(),
                new TypeReference<List<Ingredient>>() {
                });
    }

    public Ingredient getRandom(){
        Random random = new Random();
        return this.ingredientList.get(random.nextInt(100));
    }

    public Ingredient getWithName(String ingredientName){
        Optional<Ingredient> ingredient = this.ingredientList
                .stream()
                .filter(i -> i.getName().equals(ingredientName))
                .findFirst();
        return ingredient.orElse(null);
    }
}
