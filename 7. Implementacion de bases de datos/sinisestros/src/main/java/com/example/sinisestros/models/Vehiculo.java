package com.example.sinisestros.models;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehiculo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Nullable
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private int cantidadRuedas;
}
