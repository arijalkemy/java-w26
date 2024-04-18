package org.example.calculadoradecalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private String dishName;
    private Integer caloriesQty;
    private List<IngredientDTO> ingredientsEach100Gr;
    private IngredientDTO highestCaloriesIngredient;
}
