package com.example.showroom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrendaDto {
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talla;
    private Integer cantidad;
    private Double precio_venta;
}
