package org.example.calorias.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.calorias.entity.Ingrediente;

import java.util.List;

@Data
@NoArgsConstructor
public class PlatoDTO {
    private String nombre;
    private List<IngredienteDTO> ingredientes;
}
