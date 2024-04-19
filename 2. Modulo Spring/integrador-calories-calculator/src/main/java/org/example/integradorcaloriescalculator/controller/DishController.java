package org.example.integradorcaloriescalculator.controller;


import org.example.integradorcaloriescalculator.dto.DishRequestDTO;
import org.example.integradorcaloriescalculator.dto.DishResponseDTO;
import org.example.integradorcaloriescalculator.service.impl.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class DishController {

    private final DishServiceImpl dishService;

    @Autowired
    public DishController(DishServiceImpl dishService){
        this.dishService = dishService;
    }


    @PostMapping("dish/dishCalories/")
    @ResponseBody
    public ResponseEntity<DishResponseDTO> dishCalories(@RequestBody DishRequestDTO dishRequestDTO){
        return new ResponseEntity<>(dishService.getDataInfo(dishRequestDTO), HttpStatus.OK);
    }

    @PostMapping("dish/dishCalories/massive")
    @ResponseBody
    public ResponseEntity<List<DishResponseDTO>> dishCaloriesMassive(@RequestBody List<DishRequestDTO> dishRequestDTOS){
        return new ResponseEntity<>(dishService.getMassiveInfo(dishRequestDTOS), HttpStatus.OK);
    }







}
