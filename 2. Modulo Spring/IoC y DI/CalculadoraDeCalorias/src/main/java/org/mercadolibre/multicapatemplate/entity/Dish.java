package org.mercadolibre.multicapatemplate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
public class Dish {
    private String name;
    private List<Ingredient> ingredientList;

    public int getTotalCalories(){
        return this.ingredientList.stream().mapToInt(Ingredient::getCalories).sum();
    }

    public Ingredient getMostCaloriesIngredient(){
        return this.ingredientList.stream().max(Comparator.comparing(Ingredient::getCalories)).orElseGet(null);
    }
}
