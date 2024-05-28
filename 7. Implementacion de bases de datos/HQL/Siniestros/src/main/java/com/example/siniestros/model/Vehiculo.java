package com.example.siniestros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idVehiculo;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private Integer cantidadRuedas;
    @OneToMany(mappedBy = "vehiculo")
    private List<Siniestro> siniestros;
}
