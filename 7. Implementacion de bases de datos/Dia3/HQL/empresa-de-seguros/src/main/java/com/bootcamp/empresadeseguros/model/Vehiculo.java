package com.bootcamp.empresadeseguros.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "patente")
    private String patente;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "año_de_fabricacion")
    private Integer añoDeFabricacion;

    @Column(name = "cantidad_de_ruedas")
    private Integer cantidadDeRuedas;

    @OneToMany(mappedBy = "vehiculo")
    List<Siniestro> siniestros;
}
