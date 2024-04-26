package org.bootcamp.calorias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Ingredient {
    private final String name;
    private final Integer calories;
}
