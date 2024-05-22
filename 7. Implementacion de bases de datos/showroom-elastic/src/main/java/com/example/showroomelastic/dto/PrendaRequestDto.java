package com.example.showroomelastic.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrendaRequestDto {
    private String codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String size;
    private Integer cantidad;
    private Double precioVenta;
}
