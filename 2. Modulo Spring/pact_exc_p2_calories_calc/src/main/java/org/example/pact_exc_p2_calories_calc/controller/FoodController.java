package org.example.pact_exc_p2_calories_calc.controller;

import org.example.pact_exc_p2_calories_calc.dto.DishRequestDTO;
import org.example.pact_exc_p2_calories_calc.dto.DishResponseDTO;
import org.example.pact_exc_p2_calories_calc.dto.IngredientDTO;
import org.example.pact_exc_p2_calories_calc.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {
    @Autowired
    IFoodService foodService;

    @GetMapping("/ingredient")
    @ResponseBody
    public IngredientDTO ingredientCal(@RequestParam String ingredient) {
        return foodService.getIngredientCal(ingredient);
    }

    @GetMapping("/dishCalories")
    @ResponseBody
    public DishResponseDTO calcCalories(@RequestBody DishRequestDTO dish) {
        return foodService.getDishCalories(dish);
    }

    @GetMapping("/dishListCal")
    @ResponseBody
    public List<DishResponseDTO> dishListCal(@RequestBody List<DishRequestDTO> dishList) {
        return foodService.getDishCalList(dishList);
    }
}
