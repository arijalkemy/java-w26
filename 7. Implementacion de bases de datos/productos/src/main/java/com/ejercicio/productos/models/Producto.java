public package com.ejercicio.productos.models;

import org.springframework.data.elasticsearch.annotations.Document;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "producto")
public class Producto {
    private String nombre;
    private String tipo;
    private Double precioDeVenta;
    private Double precioDeCosto;
    private Integer cantidadDisponible;
}
}
