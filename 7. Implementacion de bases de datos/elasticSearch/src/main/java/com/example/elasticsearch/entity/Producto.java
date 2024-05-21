package com.example.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "productos_")
public class Producto {
    @Id
    private String id;
    private String nombre;
    private String tipo;
    private Double precio;
    private Double costo;
    private Integer cantidad;
}
