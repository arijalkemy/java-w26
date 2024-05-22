package com.ejerciciosjpa.nosqlimpl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoResponseDto {
    private String id;
    private String nombre;
    private String tipo;
    private Double precioVenta;
    private Double precioCosto;
    private Integer cantidadDisponible;
}
