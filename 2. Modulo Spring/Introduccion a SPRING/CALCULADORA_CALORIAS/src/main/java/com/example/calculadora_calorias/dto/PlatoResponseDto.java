package com.example.calculadora_calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlatoResponseDto {
    private Integer totalCalorias;
    private List<IngredientDto> ingredients;
    private IngredientDto mostCaloricIngredient;
}
