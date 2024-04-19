package org.example.integradorcaloriescalculator.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor

public class Dish {

    private String name;
    private List<Ingredient> ingredients;

}
