package com.prendaselastic.DTOs.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PrendaResponseDTO {
    private String codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talle;
    private Integer cantidad;
    @JsonProperty("precio_venta")
    private Double precioVenta;
}
