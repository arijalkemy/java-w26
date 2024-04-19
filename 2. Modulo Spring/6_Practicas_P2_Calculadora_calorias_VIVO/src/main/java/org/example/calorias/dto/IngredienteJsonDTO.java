package org.example.calorias.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class IngredienteJsonDTO {
    private String name;
    private int calories;
}
