package com.bootcamp.joyeriacrud.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "joya")
public class Jewelry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nro_identificatorio")
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "material")
    private String material;

    @Column(name = "peso")
    private double weight;

    @Column(name = "particularidad")
    private String peculiarity;

    @Column(name = "posee_piedra")
    private boolean hasStone;

    @Column(name = "venta_o_no")
    private boolean sellOrNot = true;
}
