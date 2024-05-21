package com.vehiculossegurovivo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patente;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private Integer cantidadRuedas;
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    List<Siniestro> siniestros;
}
