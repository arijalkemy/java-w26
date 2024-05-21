package com.example.joyeria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long nro_identificatorio;
    String nombre;
    String material;
    double peso;
    String particularidad;
    boolean posee_piedra;
    boolean ventaONo;
}
