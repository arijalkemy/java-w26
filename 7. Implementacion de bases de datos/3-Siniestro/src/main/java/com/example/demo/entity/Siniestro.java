package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Siniestro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaSiniestro;
    private double perdidaEconomica;
    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculoDenunciado;

}
