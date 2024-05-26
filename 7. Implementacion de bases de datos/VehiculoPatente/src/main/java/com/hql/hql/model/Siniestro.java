package com.hql.hql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table( name = "Siniestro")
@Getter @Setter
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_siniestro")
    private int idSiniestro;

    @Column(name = "fecha_siniestro")
    private Date fechaSiniestro;

    @Column(name = "perdida_economica")
    private double perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo_denunciado")
    private Vehiculo vehiculoDenunciado;
}
