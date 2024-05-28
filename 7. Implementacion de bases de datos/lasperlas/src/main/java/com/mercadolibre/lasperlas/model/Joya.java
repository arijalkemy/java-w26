package com.mercadolibre.lasperlas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nro_id")
    private Long nroId;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @Column(name = "posee_piedra", nullable = false)
    private boolean poseePiedra;
    private boolean ventaONo;


}
