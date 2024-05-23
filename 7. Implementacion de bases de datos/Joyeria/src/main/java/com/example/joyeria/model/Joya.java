package com.example.joyeria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "joya")
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="nombre", length = 50)
    private String nombre;

    @Column(name="material", length = 24)
    private String material;

    @Column(name="peso")
    private Long peso;

    @Column(name="particularidad")
    private String particularidad;

    @Column(name="posee_piedra")
    private Boolean posee_piedra;

    @Column(name="ventaONo")
    private Boolean ventaONo;

}
