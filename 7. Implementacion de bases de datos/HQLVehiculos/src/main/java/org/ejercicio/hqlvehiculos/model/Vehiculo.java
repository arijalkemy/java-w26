package org.ejercicio.hqlvehiculos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idVehículo;

    private String Patente;

    private String Marca;

    private String Modelo;

    private LocalDate fechaFabricacion;

    private Integer cantidadDeRuedas;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehiculo")
    private List<Siniestro> siniestros;
}
