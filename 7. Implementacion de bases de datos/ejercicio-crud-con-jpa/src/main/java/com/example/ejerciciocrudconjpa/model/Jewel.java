package com.example.ejerciciocrudconjpa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "jewel")
public class Jewel {
    @Id
    @Column(name = "nro_identificatorio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nroIdentificatorio;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "material", length = 50)
    private String material;

    @Column
    private Double peso;

    @Column(name = "particularidad", length = 100)
    private String particularidad;

    @Column
    private Boolean poseePiedra;

    @Column
    private Boolean ventaONo = true;
}
