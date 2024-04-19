package com.w26.countercalories.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Portion {
    private Ingredient ingredient;
    private int porcentage;

    public static Portion of(Ingredient ingredient, int porcentage)
    {
        return new Portion(ingredient, porcentage);
    }

    public float calculateCalories(int grameDish)
    {
        float calories = 0;
        float countGramsIngredient  =  ((this.getPorcentage() / 100f) * grameDish);
        calories = (countGramsIngredient / 100f) * this.getIngredient().getCalories();
        return  calories;
    }
}
