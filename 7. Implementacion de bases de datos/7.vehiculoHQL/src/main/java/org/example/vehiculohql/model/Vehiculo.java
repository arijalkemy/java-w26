package org.example.vehiculohql.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.vehiculohql.controller.VehiculoController;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patente;
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private int cantidadRuedas;

    @OneToMany(mappedBy = "vehiculoDenunciado")
    Set<Siniestro> siniestros;

    public Vehiculo(String marca, String patente) {
        this.marca = marca;
        this.patente = patente;
    }
}