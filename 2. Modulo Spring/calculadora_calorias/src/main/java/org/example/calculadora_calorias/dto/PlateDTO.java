package org.example.calculadora_calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.calculadora_calorias.model.Ingredient;
import org.example.calculadora_calorias.model.Plate;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlateDTO {
    private String name;
    private List<IngredientDTO> ingredients = new ArrayList<>();
    private Integer totalCalories;

    public PlateDTO(Plate plate) {
        this.name=plate.getName();
        this.ingredients=plate.getIngredients();
        this.totalCalories= plate.getIngredients().stream().mapToInt(x->x.getCalories()).sum();
    }
}
