package com.example.calculadora_calorias.service.FoodService;

import com.example.calculadora_calorias.dto.PlatoRequestDto;
import com.example.calculadora_calorias.dto.PlatoResponseDto;

import java.util.List;

public interface IFoodService {
    PlatoResponseDto findDishCalories(PlatoRequestDto platoRequestDto);
    List<PlatoResponseDto> findDishListCalories(List<PlatoRequestDto> platoRequestDto);
}
