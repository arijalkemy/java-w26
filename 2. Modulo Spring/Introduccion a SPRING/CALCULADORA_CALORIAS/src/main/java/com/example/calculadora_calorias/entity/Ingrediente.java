package com.example.calculadora_calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {
    private String name;
    private Integer calories;
    private Float weight;
}
