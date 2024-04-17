package com.example.calculadora_calorias.controller;

import com.example.calculadora_calorias.dto.PlatoRequestDto;
import com.example.calculadora_calorias.dto.PlatoResponseDto;
import com.example.calculadora_calorias.service.FoodService.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class FoodController {

    @Autowired
    IFoodService foodService;

    @GetMapping("/plato/calorias")
    public ResponseEntity<PlatoResponseDto> findDishCalories(@RequestBody PlatoRequestDto platoRequestDto){
        PlatoResponseDto platoResponseDto = foodService.findDishCalories(platoRequestDto);
        return new ResponseEntity<>(platoResponseDto, HttpStatus.OK);
    }

    @GetMapping("/plato/calorias/all")
    public ResponseEntity<List<PlatoResponseDto>> findDishListCalories(@RequestBody List<PlatoRequestDto> platosRequestDto){
        List<PlatoResponseDto> platosResponseDto = foodService.findDishListCalories(platosRequestDto);
        return new ResponseEntity<>(platosResponseDto, HttpStatus.OK);
    }

}
