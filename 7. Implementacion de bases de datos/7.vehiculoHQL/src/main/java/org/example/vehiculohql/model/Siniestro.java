package org.example.vehiculohql.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date fechaSiniestro;

    private double perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculoDenunciado;
}

