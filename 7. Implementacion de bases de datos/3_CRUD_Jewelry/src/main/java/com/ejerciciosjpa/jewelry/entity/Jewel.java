package com.ejerciciosjpa.jewelry.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Setter;
import lombok.Getter;

@Entity
@Setter @Getter
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean poseePiedra;
    private Boolean ventaONo;
}
