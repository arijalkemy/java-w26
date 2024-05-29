package com.w26.seguros_autos.seguros_autos.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "vehiculo")
public class Vehiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id;

    String patente;
    String marca;
    String modelo;
    Integer cantidadRuedas;
    LocalDate anoFabricacion;

    @OneToMany(mappedBy = "vehiculo", fetch = FetchType.LAZY)
    List<Siniestro> siniestrosDenunciados;
}
