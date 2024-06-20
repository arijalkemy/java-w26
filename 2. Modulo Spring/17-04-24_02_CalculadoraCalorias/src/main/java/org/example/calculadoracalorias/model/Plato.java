package org.example.calculadoracalorias.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plato {
    private String name;
    private int weight;
    private List<Ingrediente> ingredients;
}
