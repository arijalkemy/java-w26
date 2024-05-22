package org.example.vehiculossiniestros.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "siniestros")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    LocalDate fechaSiniestro;
    double perdidaEconomica;
    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    Vehiculo vehiculo;
}
