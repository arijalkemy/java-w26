package org.example.productoelastic.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Data
@Document(indexName = "producto")
public class Producto {
    @Id
    private String id;
    private String nombre;
    private Tipo tipo;
    private Double precio_venta;
    private Double precio_costo;
    private Integer cantidad_disponible;
}
