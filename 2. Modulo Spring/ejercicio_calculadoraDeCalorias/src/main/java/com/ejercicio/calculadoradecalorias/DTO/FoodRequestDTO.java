package com.ejercicio.calculadoradecalorias.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FoodRequestDTO {
    private String name;
    private int weight;
}
