package com.prendaselastic.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "prendas")
@Data
public class Prenda {
    @Id
    private String codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talle;
    private Integer cantidad;
    private Double precioVenta;
}
