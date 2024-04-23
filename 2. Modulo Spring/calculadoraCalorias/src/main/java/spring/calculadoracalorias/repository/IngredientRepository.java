package spring.calculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import spring.calculadoracalorias.entity.Ingredient;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepository implements IIngredientRepository {

    private List<Ingredient> listOfIngredients = new ArrayList<>();

    public IngredientRepository() {
        loadDataBase();
    }

    private void loadDataBase() {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Ingredient> ingredients;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
            ingredients = objectMapper.readValue(file, new TypeReference<List<Ingredient>>() {
            });
            listOfIngredients = ingredients;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Ingredient getIngredientByName(String name) {
        Optional<Ingredient> ingredient = listOfIngredients.stream().filter(i -> i.getName().equalsIgnoreCase(name)).findFirst();

        if (ingredient.isPresent()) {
            return ingredient.get();
        } else {
            return null;
        }
    }

    public List<Ingredient> findAll() {
        return this.listOfIngredients;
    }



}
