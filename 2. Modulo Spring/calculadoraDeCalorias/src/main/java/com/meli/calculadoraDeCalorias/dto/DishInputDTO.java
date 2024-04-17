package com.meli.calculadoraDeCalorias.dto;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class DishInputDTO implements Serializable{
    private String name;
    private List<String> ingredientName;
    private double weight;
}
