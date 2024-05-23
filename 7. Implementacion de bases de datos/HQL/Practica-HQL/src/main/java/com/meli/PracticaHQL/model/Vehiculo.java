package com.meli.PracticaHQL.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anioDeFabricacion;
    private int cantidadDeRuedas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculo")
    private Set<Siniestro> siniestros;

    public Vehiculo(String patente, String marca, String modelo, Integer anioDeFabricacion, int cantidadDeRuedas) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.anioDeFabricacion = anioDeFabricacion;
        this.cantidadDeRuedas = cantidadDeRuedas;
    }
}
