package com.ejercicio.productos.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "producto")
public class Producto {
    @Id
    private String id;
    private String nombre;
    private String tipo;
    private Double precioDeVenta;
    private Double precioDeCosto;
    private Integer cantidadDisponible;
}
