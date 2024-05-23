package org.example.ejercicios_extra_elasticsearch.dto;

import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

@Value
public class PrendaRequestDto implements Serializable {
    String nombre;
    String tipo;
    String marca;
    String color;
    String talle;
    Integer cantidad;
    BigDecimal precioVenta;
}