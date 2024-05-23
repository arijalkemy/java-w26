package com.prendas.DTOs.request;

import lombok.Data;

@Data
public class PrendaRequestDTO {
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talle;
    private Integer cantidad;
    private Double precioVenta;
}
