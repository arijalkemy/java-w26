package com.hql.hql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table( name = "Vehiculo")
@Getter @Setter
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private int idVehiculo;

    @Column(name = "patente")
    private String patente;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "anio_fabricacion")
    private int anioFabricacion;

    @Column(name = "cantidad_ruedas")
    private int cantidadRuedas;

    @OneToMany(mappedBy = "vehiculoDenunciado", cascade = CascadeType.ALL)
    private List<Siniestro> siniestros;
}
