package com.meli.calculadoraDeCalorias.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class DishInputDTO implements Serializable {
    private String name;
    private Integer weight;
}
