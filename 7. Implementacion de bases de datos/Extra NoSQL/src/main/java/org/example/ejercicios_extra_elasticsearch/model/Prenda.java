package org.example.ejercicios_extra_elasticsearch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Document(indexName = "prendas")
public class Prenda {

    @Id
    private String id;

    private String nombre;

    private String tipo;

    private String marca;

    private String color;

    private String talle;

    private Integer cantidad;

    private BigDecimal precioVenta;
}
