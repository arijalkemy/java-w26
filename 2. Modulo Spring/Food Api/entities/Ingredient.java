package org.example.calories.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {
    private String name;
    private Integer calories;

    public Ingredient() {
    }
}
