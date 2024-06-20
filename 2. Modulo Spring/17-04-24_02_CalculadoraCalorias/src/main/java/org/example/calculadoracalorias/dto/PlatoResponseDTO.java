package org.example.calculadoracalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoResponseDTO {
    private String name;
    private int totalCalories;
    private List<IngredienteDTO> ingredients;
    private IngredienteDTO highestCalorieIngredient;
}
