package org.example.integradorcaloriescalculator.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Ingredient {

    private String name;
    private int calories;

    public Ingredient(){}
}
