package org.miprimerproyecto.calculadoracalorias.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    private String name;
    private List<Ingredient> ingredientList;
    private int weight;

}
