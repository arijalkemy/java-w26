package com.practicasextra.showroom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Prenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "marca")
    private String marca;

    @Column(name = "color")
    private String color;

    @Column(name = "talle")
    private String talle;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio_venta")
    private Double precio_venta;
}
