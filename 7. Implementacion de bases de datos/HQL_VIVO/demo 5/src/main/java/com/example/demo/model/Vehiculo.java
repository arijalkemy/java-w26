package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String patente;
    String marca;
    String modelo;
    int ano;
    int cantidadRuedas;

    @OneToMany(mappedBy = "vehiculo")
    List<Siniestro> siniestros;

}
