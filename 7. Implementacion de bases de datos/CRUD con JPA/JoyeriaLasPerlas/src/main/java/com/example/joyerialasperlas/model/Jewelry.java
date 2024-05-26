package com.example.joyerialasperlas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Jewelry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nro_identificatorio")
    private Long nroIdentificatorio;

    private String nombre;

    private String material;

    private Double peso;

    private String particularidad;

    @Column(name = "posee_piedra")
    @JsonProperty("posee_piedra")
    private Boolean poseePiedra;

    private Boolean ventaONo;
}
