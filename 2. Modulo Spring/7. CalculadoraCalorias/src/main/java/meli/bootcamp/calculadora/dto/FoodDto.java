package meli.bootcamp.calculadora.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import meli.bootcamp.calculadora.entity.Ingredient;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodDto {
    private String name;
    private Integer calories;
    private List<Ingredient> ingredients;
    private Ingredient maxCaloriesIngredient;
}
