package com.mercadolibre.CalculadoraDeCalorias.controller;

import com.mercadolibre.CalculadoraDeCalorias.dto.DishDTO;
import com.mercadolibre.CalculadoraDeCalorias.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    IDishService dishService;

    @RequestMapping("/search")
    public DishDTO getDishForName(@RequestParam String name){
        return dishService.findDish(name);
    }

}
