package com.w26.countercalories.controller;

import com.w26.countercalories.dto.DishDTOInput;
import com.w26.countercalories.dto.DishDTOOutput;
import com.w26.countercalories.service.DishIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class DishIngredientController {

    private final DishIngredientService dishIngredientService;

    public DishIngredientController(DishIngredientService dishIngredientService) {
        this.dishIngredientService = dishIngredientService;
    }


    @PostMapping("/dishinfo")
    public ResponseEntity<DishDTOOutput> getDishIngredientByDish(@RequestBody DishDTOInput request)
    {
        return new ResponseEntity(dishIngredientService.getDishInfo(request), HttpStatus.OK);
    }

    @PostMapping("/dishesinfo")
    public ResponseEntity<List<DishDTOOutput>> getDishIngredientByDish(@RequestBody List<DishDTOInput> request)
    {
        return new ResponseEntity(dishIngredientService.getDishesInfo(request), HttpStatus.OK);
    }
}
