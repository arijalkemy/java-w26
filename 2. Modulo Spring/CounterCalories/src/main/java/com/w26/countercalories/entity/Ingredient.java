package com.w26.countercalories.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Ingredient {
    private String name;
    private int calories; //Calories x cada 100 gramos

    public Ingredient(){}
}
