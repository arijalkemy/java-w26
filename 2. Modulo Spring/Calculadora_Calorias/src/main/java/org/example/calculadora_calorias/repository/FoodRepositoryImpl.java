package org.example.calculadora_calorias.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.calculadora_calorias.dto.EntryFoodList;
import org.example.calculadora_calorias.dto.FoodDTO;
import org.example.calculadora_calorias.model.Food;
import org.example.calculadora_calorias.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class FoodRepositoryImpl implements FoodRepository {

    List<Food> foodList;
    List<Ingredient> ingredients;

    FoodRepositoryImpl(){
        foodList = new ArrayList<>();
        ingredients = loadIngredients();
        loadFood();
    }

    public List<Ingredient> generateRandomListIngredients(){
        Random random = new Random();
        int randomIngredientsNumber = random.nextInt(2, 6);
        List<Ingredient> randomIngredientsList = new ArrayList<>();
        for (int i = 0; i < randomIngredientsNumber; i++) {
            int randomIndex = random.nextInt(ingredients.size());
            Ingredient ingredient = ingredients.get(randomIndex);
            randomIngredientsList.add(ingredient);
        }
        return randomIngredientsList;
    }

    public void loadFood(){

        String[] platosMexicanos = {
                "Tacos al Pastor",
                "Tamales",
                "Pozole",
                "Chiles en Nogada",
                "Enchiladas",
                "Mole Poblano",
                "Cochinita Pibil",
                "Tostadas",
                "Sopes",
                "Quesadillas",
                "Chilaquiles",
                "Guacamole",
                "Flautas",
                "Ceviche",
                "Huaraches",
                "Molletes",
                "Chapulines",
                "Menudo",
                "Tlayudas",
                "Empanadas"
        };

        for (String plato : platosMexicanos) {
            foodList.add(new Food(generateRandomListIngredients(), plato));
        }
    }

    @Override
    public Food getFoodByName(String foodName) {
        return foodList.stream().filter(food -> food.getName().equalsIgnoreCase(foodName)).findAny().orElse(null);
    }

    @Override
    public List<Food> getFoodListByNames(EntryFoodList foodNames) {
        return foodList.stream()
                .filter(food -> foodNames.getFoodNames().contains(food.getName()))
                .toList();
    }

    private List<Ingredient> loadIngredients(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:data/data.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
