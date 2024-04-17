package com.caloriescounter.caloriescounter.model;

import java.util.List;

import lombok.Data;

@Data
public class Plate {
    private String plateName;
    private List<Ingredient> plateIngredients;

    public Plate(String plateName, List<Ingredient> plateIngredients) {
        this.plateName = plateName;
        this.plateIngredients = plateIngredients;
    }

    
}
