package com.ejerciciosjpa.extrajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClothResponseDto {
    private Long codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private Integer talle;
    private Integer cantidad;
    private Double precioVenta;
}
