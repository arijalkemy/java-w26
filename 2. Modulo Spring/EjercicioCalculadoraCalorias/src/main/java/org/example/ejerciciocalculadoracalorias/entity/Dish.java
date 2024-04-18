package org.example.ejerciciocalculadoracalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor
public class Dish {
    private String name;
    private Integer weight;
    private List<Ingredients> ingredientsList;
}
