package org.example.calculadora_calorias.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Ingredient {
    private String name;
    private Integer calories;
}
