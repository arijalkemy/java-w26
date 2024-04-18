package com.example.calorias.DTOs;

import com.example.calorias.modelo.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.List;

@Data
public class PlatoDTO {
    private String nombre;
    private List<Ingrediente> ingredientes;
    private int totalCalorias;
    private Ingrediente ingredienteConMasCalorias;

    public PlatoDTO(String nombre, List<Ingrediente> ingredientes, int totalCalorias,
                    Ingrediente ingredienteConMasCalorias) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.totalCalorias = totalCalorias;
        this.ingredienteConMasCalorias = ingredienteConMasCalorias;
    }
}
