package org.bootcamp.joyerialasperlas.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "nro_identificatorio")
    private Long idJoya;
    private String nombre;
    private String material;
    private float peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaOno;
}
