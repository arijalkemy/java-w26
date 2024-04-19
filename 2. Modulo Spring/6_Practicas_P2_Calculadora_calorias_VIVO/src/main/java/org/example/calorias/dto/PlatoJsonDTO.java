package org.example.calorias.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PlatoJsonDTO {
    private String name;
    private List<IngredienteJsonDTO> ingredients;
}
