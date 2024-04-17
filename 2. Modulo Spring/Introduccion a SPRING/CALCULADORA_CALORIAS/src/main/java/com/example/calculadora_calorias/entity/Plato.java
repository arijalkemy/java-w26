package com.example.calculadora_calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Plato {
    private Integer totalCalorias;
    private List<Ingrediente> ingredientes;

}
