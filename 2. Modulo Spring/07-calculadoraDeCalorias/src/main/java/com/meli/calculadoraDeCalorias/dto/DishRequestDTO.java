package com.meli.calculadoraDeCalorias.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class DishRequestDTO implements Serializable {
    private String name;
    private Integer weight;
}
