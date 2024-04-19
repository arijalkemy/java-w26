package com.example.calorias.DTOs;

import com.example.calorias.modelo.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.List;

@Data
public class PlatoDTO {
    private String nombre;
    private List<IngredienteDTO> ingredientes;
    private int totalCalorias;
    private IngredienteDTO ingredienteConMasCalorias;

    public PlatoDTO(String nombre, List<IngredienteDTO> ingredientes) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.totalCalorias = ingredientes.stream().mapToInt(i -> i.getCalorias()).sum();
        this.ingredienteConMasCalorias =
                ingredientes
                        .stream()
                        .max(Comparator.comparingInt(IngredienteDTO::getCalorias))
                        .orElse(null);
    }
}
