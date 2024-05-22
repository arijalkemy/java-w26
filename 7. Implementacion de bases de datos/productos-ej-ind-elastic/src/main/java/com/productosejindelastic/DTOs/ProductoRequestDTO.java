package com.productosejindelastic.DTOs;

import lombok.Data;

@Data
public class ProductoRequestDTO {
    private String nombre;
    private String tipo;
    private Double precioVenta;
    private Double precioCosto;
    private Integer cantidadDisponible;
}
