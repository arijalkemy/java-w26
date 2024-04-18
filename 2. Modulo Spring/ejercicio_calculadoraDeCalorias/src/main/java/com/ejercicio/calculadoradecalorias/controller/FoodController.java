package com.ejercicio.calculadoradecalorias.controller;

import com.ejercicio.calculadoradecalorias.DTO.FoodRequestDTO;
import com.ejercicio.calculadoradecalorias.DTO.FoodResponseDTO;
import com.ejercicio.calculadoradecalorias.service.interfaces.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    IFoodService foodService;

    @GetMapping()
    public ResponseEntity<?> getFoodResponse(@RequestParam String name,
                                             @RequestParam int weight) {
        try {
            FoodResponseDTO result = foodService.createResponse(name, weight);
            return ResponseEntity.status(200).body(result);
        }
        catch (Exception ex) {
            return ResponseEntity
                    .status(400)
                    .body(ex.getMessage());
        }
    }
}
