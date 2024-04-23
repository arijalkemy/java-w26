package org.bootcamp.calorias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Dish {
    private final String name;
    private List<Ingredient> ingredients;
}
