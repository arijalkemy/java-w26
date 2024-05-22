package com.implementaciondb.ejercicio8_productos_elasticsearch.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("precio_venta")
    private Double precioVenta;

    @JsonProperty("precio_costo")
    private Double precioCosto;

    @JsonProperty("cantidad_disponible")
    private Integer cantidadDisponible;
}
