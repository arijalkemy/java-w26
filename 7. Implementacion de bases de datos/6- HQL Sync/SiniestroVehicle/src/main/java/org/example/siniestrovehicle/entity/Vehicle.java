package org.example.siniestrovehicle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    @Column(name = "anio_fabricacion")
    private Long anioFabricacion;
    @Column(name = "cantidad_ruedas")
    private Integer cantidadRuedas;
}
