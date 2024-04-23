package spring.calculadoracalorias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.calculadoracalorias.entity.Dish;
import spring.calculadoracalorias.entity.Ingredient;
import spring.calculadoracalorias.service.IDishService;

@RestController
public class DishController {

    @Autowired
    IDishService dishService;

    @GetMapping("/calories")
    public ResponseEntity<Double> getCalories(@RequestParam String dishName, @RequestParam double weight) {
        double totalCalories = dishService.calculateCalorias(dishName, weight);
        return ResponseEntity.ok(totalCalories);
    }


    @GetMapping("/dish")
    public ResponseEntity<String> getListIngredientsCalories(@RequestParam String dishName, @RequestParam double weight) {
        return new ResponseEntity<String>(dishService.listIngredientsCalories(dishName, weight), HttpStatus.OK);
    }

    @GetMapping("/dish/ingredientMoreCalories")
    public ResponseEntity<Ingredient> getIngredientHighestCalories(@RequestParam String dishName, @RequestParam double weight) {
        return new ResponseEntity<Ingredient>(dishService.getIngredientWitHighestAmountCalories(dishName,weight), HttpStatus.OK);
    }

}
