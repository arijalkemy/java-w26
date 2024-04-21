package org.example.calculadora_calorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.calculadora_calorias.model.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepository implements IIngredientRepository {

    private List<Ingredient> ingredients = new ArrayList<>();
    public IngredientRepository()  {
        ingredients = this.loadDatabase();
    }

    @Override
    public List<Ingredient> findAll() {
        return this.ingredients;
    }

    @Override
    public Ingredient findByName(String name) {
        return this.ingredients.stream().filter(ingredient -> ingredient.getName().equals(name)).findFirst().orElse(null);
    }
    private List<Ingredient> loadDatabase ()  {
        List<Ingredient> ingredientList = new ArrayList<>();
        try{
            File file = ResourceUtils.getFile("classpath:ingredients.json");
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Ingredient>> typeReference = new TypeReference<>() {};
            try {
                ingredientList = mapper.readValue(file, typeReference);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return ingredientList;
    }

}
