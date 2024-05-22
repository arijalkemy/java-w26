package org.implementaciondb.ejercicio6_vehiculos_siniestros.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sinisters")
public class Sinister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sinister_id")
    private Long id;

    @Column(name = "sinister_date", nullable = false)
    private LocalDate sinisterDate;

    @Column(name = "economic_loss", nullable = false)
    private double economicLoss;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id", nullable = false)
    private Vehicle vehicle;

}
