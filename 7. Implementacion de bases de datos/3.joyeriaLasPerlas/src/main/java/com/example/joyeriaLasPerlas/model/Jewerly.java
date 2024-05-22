package com.example.joyeriaLasPerlas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="jewerly")
public class Jewerly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean ventaONo;
}
