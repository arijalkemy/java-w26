package org.bootcamp.calorias.controller;

import org.bootcamp.calorias.dto.DishRequestDTO;
import org.bootcamp.calorias.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/")
    private ResponseEntity<?> getAll(){
        return ResponseEntity.ok(dishService.getAll());
    }

    @GetMapping("")
    private ResponseEntity<?> getTotalCalories(@RequestParam String name, @RequestParam Integer weight){
        return ResponseEntity.ok(dishService.getTotalCalories(new DishRequestDTO(name, weight, new ArrayList<>())));
    }

    @PostMapping("/")
    private ResponseEntity<?> saveDish(@RequestBody DishRequestDTO dishRequestDTO){
        return ResponseEntity.ok(dishService.saveDish(dishRequestDTO));
    }

    @PostMapping("/saveAll/")
    private ResponseEntity<?> saveDishAll(@RequestBody List<DishRequestDTO> requestDTOList){
        return ResponseEntity.ok(dishService.saveDishAll(requestDTOList));
    }


}
