package com.meli.PracticaHQL.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Siniestro {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDate fechaDelSiniestro;
    private Double perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;
}
