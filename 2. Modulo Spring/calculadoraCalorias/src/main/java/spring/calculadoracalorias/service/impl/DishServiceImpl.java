package spring.calculadoracalorias.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.calculadoracalorias.entity.Dish;
import spring.calculadoracalorias.entity.Ingredient;
import spring.calculadoracalorias.repository.DishRepository;
import spring.calculadoracalorias.repository.IDishRepository;
import spring.calculadoracalorias.service.IDishService;

import java.util.Comparator;
import java.util.Optional;

@Service
public class DishServiceImpl implements IDishService {

    IDishRepository dishRepository = new DishRepository();


    public double calculateCalorias(String dishName, double weight) {
        double totalCalories = 0;

        Dish dish = this.dishRepository.getDishByName(dishName, weight);
        dish.setWeight(weight);
        for (Ingredient ingredient : dish.getIngredients()) {
            totalCalories += (ingredient.getCalories() / 100.0) * dish.getWeight();

        }
        return totalCalories;
    }

    public String listIngredientsCalories(String name, double weight) {
        Dish dish = dishRepository.getDishByName(name, weight);
        String retorno = "El plato " + name + " de peso " + weight + " contiene: \n";

        for (Ingredient ingredient : dish.getIngredients()) {
            retorno +=  ingredient.getName() + " con " +
                    ingredient.getCalories() + " calorias\n";
        }
        return retorno;
    }

    public Ingredient getIngredientWitHighestAmountCalories(String name, double weight){
        Dish dish = dishRepository.getDishByName(name, weight);

        return  dish.getIngredients()
                .stream()
                .max(Comparator.comparingInt(Ingredient::getCalories)).orElse(null);
    }
}
