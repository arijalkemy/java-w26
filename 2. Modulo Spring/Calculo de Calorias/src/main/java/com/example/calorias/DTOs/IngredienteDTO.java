package com.example.calorias.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredienteDTO {
    private String nombre;
    private int calorias;
    private int peso;

}
