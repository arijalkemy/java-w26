package com.demospring.joyerialasperlas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "joyas")
@Getter @Setter
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String material;
    @Column
    private int peso;
    @Column
    private String particularidad;
    @Column(name = "posee_piedra")
    private boolean poseePiedra;
    @Column
    private boolean ventaONo;
}
