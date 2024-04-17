package com.meli.calculadoraDeCalorias.controller;

import com.meli.calculadoraDeCalorias.dto.DishRequestDTO;
import com.meli.calculadoraDeCalorias.dto.DishResponseDTO;
import com.meli.calculadoraDeCalorias.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {
    @Qualifier("dishServiceImpl")
    @Autowired
    private IDishService dishService;

    @PostMapping("/calculateCalories")
    public ResponseEntity<DishResponseDTO> getDishInfo(@RequestBody DishRequestDTO dishRequestDTO){
        DishResponseDTO dishResponseDTO = dishService.getDishInfo(dishRequestDTO);
        if(dishResponseDTO != null){
            return ResponseEntity.ok(dishResponseDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/calculateAllCalories")
    public ResponseEntity<List<DishResponseDTO>> getDishesInfo(@RequestBody List<DishRequestDTO> listDishesRequestDTO){
        List<DishResponseDTO> dishesResponseDTO = dishService.getDishesInfo(listDishesRequestDTO);
        if(!dishesResponseDTO.isEmpty()){
            return ResponseEntity.ok(dishesResponseDTO);
        }
        return ResponseEntity.notFound().build();
    }
}
