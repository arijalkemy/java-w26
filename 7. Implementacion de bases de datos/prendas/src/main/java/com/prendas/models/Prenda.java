package com.prendas.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "prendas")
@Data
public class Prenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talle;
    private Integer cantidad;
    private Double precioVenta;
}
