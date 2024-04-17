package com.meli.calculadoraDeCalorias.controller;

import com.meli.calculadoraDeCalorias.dto.DishInputDTO;
import com.meli.calculadoraDeCalorias.dto.DishResponseDTO;
import com.meli.calculadoraDeCalorias.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dishes")
public class DishController {
    @Autowired
    private IDishService dishService;

    @PostMapping("/calculateCalories")
    public ResponseEntity<DishResponseDTO> getDishInfo(@RequestBody DishInputDTO dishInputDTO){
        DishResponseDTO dishResponseDTO = dishService.getDishInfo(dishInputDTO);
        if(dishResponseDTO != null){
            return ResponseEntity.ok(dishResponseDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/calculateCalories/all")
    public ResponseEntity<List<DishResponseDTO>> getDishInfoAll(@RequestBody List<DishInputDTO> dishInputDTOs){
        List<DishResponseDTO> dishResponseDTOs = dishInputDTOs.stream()
                .map(dishInputDTO -> dishService.getDishInfo(dishInputDTO))
                .toList();
        if(!dishResponseDTOs.contains(null)){
            return ResponseEntity.ok(dishResponseDTOs);
        }
        return ResponseEntity.notFound().build();
    }
}
