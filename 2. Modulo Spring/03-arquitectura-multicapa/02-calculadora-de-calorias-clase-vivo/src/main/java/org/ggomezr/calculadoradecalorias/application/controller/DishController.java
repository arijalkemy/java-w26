package org.ggomezr.calculadoradecalorias.application.controller;

import org.ggomezr.calculadoradecalorias.application.service.impl.DishService;
import org.ggomezr.calculadoradecalorias.domain.dto.DishDTO;
import org.ggomezr.calculadoradecalorias.domain.entity.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/getAllDishes")
    public ResponseEntity<List<Dish>> getAllDishes(){
        List<Dish> dishes = dishService.getAllDishes();
        if(!dishes.isEmpty()) return new ResponseEntity<>(dishes, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{name}/{grams}")
    public ResponseEntity<DishDTO> getDishDetails(@PathVariable String name, @PathVariable int grams){
        Dish dishFound = dishService.getDishByName(name);
        DishDTO dish = dishService.getDishDetails(dishFound, grams);

        if(dish != null) return new ResponseEntity<>(dish, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
