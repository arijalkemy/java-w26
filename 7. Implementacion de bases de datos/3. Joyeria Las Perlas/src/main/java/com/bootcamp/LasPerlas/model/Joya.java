package com.bootcamp.LasPerlas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nro_id;

    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;

    @Column(name = "poseePiedra")
    private boolean poseePiedra;

    @Column(name = "venta_o_no")
    private boolean ventaONo;
}
