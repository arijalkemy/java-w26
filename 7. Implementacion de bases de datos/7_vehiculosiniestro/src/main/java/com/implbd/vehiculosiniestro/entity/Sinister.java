package com.implbd.vehiculosiniestro.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "sinisters")
@Entity
public class Sinister {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_sinister")
    private Long idSinister;

    @Column(name = "sinister_date")
    private LocalDate sinisterDate;

    @Column(name = "loss_amount")
    private Double lossAmount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_siniter_vehicle")
    private Vehicle sinisterVehicle;

}
