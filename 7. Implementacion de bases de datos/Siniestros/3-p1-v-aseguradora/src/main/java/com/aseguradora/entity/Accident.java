package com.aseguradora.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "accidents")
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accident_id", nullable = false)
    private Integer id;

    @Column(name = "accident_date", nullable = false)
    private LocalDate accidentDate;

    @Column(name = "economic_loss", nullable = false, precision = 10, scale = 2)
    private BigDecimal economicLoss;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

}