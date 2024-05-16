package org.ejercicio.calculadoradecalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ejercicio.calculadoradecalorias.entity.Ingrediente;

import java.util.List;

@NoArgsConstructor
@Data
public class PlatoResponseDTO {
    private String nombre;
    private double totalCalorias;
    private List<IngredienteDTO> ingredientes;
    private IngredienteDTO ingredienteConMasCalorias;
}
