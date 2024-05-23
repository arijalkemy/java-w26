package com.bootcamp.vehiculo.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "siniestro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_siniestro")
    private LocalDate fechaSiniestro;

    @Column(name = "perdida_economica")
    private Double perdidaEconomica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Vehiculo vehiculo;

}
