package spring.calculadoracalorias.service;

import org.springframework.beans.factory.annotation.Autowired;
import spring.calculadoracalorias.entity.Dish;
import spring.calculadoracalorias.entity.Ingredient;
import spring.calculadoracalorias.repository.DishRepository;
import spring.calculadoracalorias.repository.IDishRepository;

public interface IDishService {


    double calculateCalorias(String dishName, double weight);
    String listIngredientsCalories(String name, double weight);
    Ingredient getIngredientWitHighestAmountCalories(String name, double weight);
}
