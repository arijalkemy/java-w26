package com.example.showroomelastic.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "clothes")
public class Clothe {
    @Id
    private String id;
    private String codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String size;
    private Integer cantidad;
    private Double precioVenta;
}
