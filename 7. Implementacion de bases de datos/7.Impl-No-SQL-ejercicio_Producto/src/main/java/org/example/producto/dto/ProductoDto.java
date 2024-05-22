package org.example.producto.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDto {
    private String id;
    private String nombre;
    private String tipo;
    private double precio;
    private double costo;
    private Integer cantidad;
}
