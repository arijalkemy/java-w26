package com.ejerciciosjpa.extrajpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clothes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cloth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private Integer talle;
    private Integer cantidad;
    private Double precioVenta;
    @ManyToOne
    @JoinColumn(name = "numero")
    private Sale sale;
}
