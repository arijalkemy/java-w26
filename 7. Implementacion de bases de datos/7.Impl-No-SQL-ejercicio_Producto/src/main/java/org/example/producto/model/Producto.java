package org.example.producto.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "productos_")
@Getter
@Setter
public class Producto {
    @Id
    private String id;
    private String nombre;
    private String tipo;
    private double precio;
    private double costo;
    private Integer cantidad;
}
