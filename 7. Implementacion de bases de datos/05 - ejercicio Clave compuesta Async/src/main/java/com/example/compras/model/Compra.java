package com.example.compras.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private LocalDate fecha;

    @Id
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Cliente clienteId;

    @Column(name = "cantidad_productos")
    private int cantidadDeProductos;

    @Column(name = "precio_final")
    private double precioFinal;
}
