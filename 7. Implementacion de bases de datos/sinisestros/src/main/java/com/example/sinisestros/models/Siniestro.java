package com.example.sinisestros.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "siniestro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDate fechaSiniestro;
    private double perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculoDenunciado;
}
