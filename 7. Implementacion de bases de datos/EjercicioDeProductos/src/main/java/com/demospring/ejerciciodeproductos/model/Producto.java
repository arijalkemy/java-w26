package com.demospring.ejerciciodeproductos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "productos")
@AllArgsConstructor
@Data
public class Producto {
    @Id
    private String id;
    private String nombre;
    private String tipo;
    private double precioVenta;
    private double precioCosto;
    private int cantidadDisponible;
}
