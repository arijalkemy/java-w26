package com.bootcamp.vehiculo.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehiculo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patente;

    private String marca;

    private String modelo;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate anioFabricacion;

    @Column(name = "cantidad_ruedas", nullable = false)
    private Integer cantidadRuedas;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehiculo")
    private List<Siniestro> siniestros;

}
