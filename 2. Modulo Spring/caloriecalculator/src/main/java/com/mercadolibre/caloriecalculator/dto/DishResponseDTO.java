package com.mercadolibre.caloriecalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DishResponseDTO {
    private String dishName;
    private Double totalCalories;
}
