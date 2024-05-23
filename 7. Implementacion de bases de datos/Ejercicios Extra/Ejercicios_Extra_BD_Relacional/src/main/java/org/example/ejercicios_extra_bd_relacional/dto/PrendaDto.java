package org.example.ejercicios_extra_bd_relacional.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PrendaDto implements Serializable {
    private Long id;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talle;
    private Integer cantidad;
    private BigDecimal precioVenta;
}