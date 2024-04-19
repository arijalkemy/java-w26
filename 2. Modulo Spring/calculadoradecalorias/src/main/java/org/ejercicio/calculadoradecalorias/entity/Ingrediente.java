package org.ejercicio.calculadoradecalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Ingrediente {
    private String name;
    private int calories;
}
