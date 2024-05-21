package com.example.consultashql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anio;
    @Column(name = "cantidad_de_ruedas")
    private Integer cantidadDeRuedas;

}
