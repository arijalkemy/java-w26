package com.ejercicio.calculadoraCalorias.Controller;


import com.ejercicio.calculadoraCalorias.dto.DishDTO;
import com.ejercicio.calculadoraCalorias.model.Food;
import com.ejercicio.calculadoraCalorias.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food/")
public class FoodController {

    @Autowired
    IFoodService iFoodService;




    @GetMapping("ping")
    public String pingPong(){
        return "Pong";
    }

    @GetMapping("GetDish")
    public DishDTO getAll(@RequestParam String name, @RequestParam double weight ){
        return iFoodService.getDish(name,weight);
    }

}
