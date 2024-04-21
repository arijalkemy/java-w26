package org.example.calculadora_calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.calculadora_calorias.model.Ingredient;

@NoArgsConstructor
@Getter
@Setter
public class IngredientDTO {
    private String name;
    private Integer calories;
    private Integer weigth;

    public IngredientDTO(String name, Integer calories, Integer weigth) {
        this.name = name;
        this.calories = (calories*weigth)/100;;
        this.weigth = weigth;
    }

    public IngredientDTO(Ingredient ingrediente, Integer weigth) {
        this.weigth=weigth;
        this.name=ingrediente.getName();
        this.calories= (ingrediente.getCalories()*weigth)/100;
    }
}
