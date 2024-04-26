package org.example.calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredienteDTO implements Serializable {
    private String name;
    private int calories;
}
