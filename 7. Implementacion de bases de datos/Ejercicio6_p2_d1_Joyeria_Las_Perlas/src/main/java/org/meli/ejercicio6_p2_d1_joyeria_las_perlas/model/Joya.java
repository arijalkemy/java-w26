package org.meli.ejercicio6_p2_d1_joyeria_las_perlas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="joyas")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @JsonIgnore
    private Long id;


    @Column(name="nombre_joya")
    private String nombre;

    @Column(name="material_joya")
    private String material;

    @Column(name="peso_joya")
    private double peso;

    @Column(name="particularidad")
    private String particularidad;

    @Column(name="posee_piedra")
    private Boolean posee_piedra;

    @Column(name="ventaONo")
    private Boolean ventaONo;

}
