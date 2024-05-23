package com.jewelry.perls.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jewerls")
public class Jewer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer nro_identificatorio;

    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;
}
