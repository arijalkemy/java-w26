package org.example.tiendadeprendas.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "prenda")
@Setter
@Getter
public class Prenda {
    @Id
    String codigo;
    String nombre;
    String marca;
    String color;
    String talla;
    Integer cantidad;
    Double precio;
}
