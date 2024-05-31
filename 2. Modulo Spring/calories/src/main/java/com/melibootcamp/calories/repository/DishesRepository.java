package com.melibootcamp.calories.repository;

import com.melibootcamp.calories.entity.Dish;
import com.melibootcamp.calories.entity.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Repository
public class DishesRepository implements IDishes{

    private List<Dish> dishList = new ArrayList<>();
    Random random = new Random();

    public DishesRepository() {
        Integer randomDishes = random.nextInt(10)+1;
        for(int i=0;i<randomDishes;i++){
            this.dishList.add(new Dish(generateRandomDish(),generateIngredientList()));
        }
        System.out.println(dishList);
    }


    // Método para generar un nombre aleatorio para el plato
    private String generateRandomDish() {
        String[] nombres = {"Hamburguesa", "Pizza", "Ensalada", "Sopa", "Pasta", "Tacos","Pollo"};

        return nombres[random.nextInt(nombres.length)];
    }

    // Método para generar una lista de ingredientes aleatorios
    private List<Ingredient> generateIngredientList() {
        List<Ingredient> randomIngredients = new ArrayList<>();
        IngredientsRepository ingredientsRepository = new IngredientsRepository();
        List<Ingredient> allIngrients = ingredientsRepository.getAll();
        Random random = new Random();
        int numIngredients = random.nextInt(5) + 1;
        for (int i = 0; i < numIngredients; i++) {
            Ingredient randomIngredient = allIngrients.get(random.nextInt(allIngrients.size()));
            randomIngredients.add(randomIngredient);
        }
        return randomIngredients;
    }

    @Override
    public List<Dish> getAll() {
        return  this.dishList.stream().toList();
    }
}
