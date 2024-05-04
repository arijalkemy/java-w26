package com.calculadora.calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatilloCompletoDTO {
    private String name;
    private int weight;
    private List<IngredienteDTO> ingredients;
    private int totalCalories;
    private IngredienteDTO ingredienteMasCalorico;
}
