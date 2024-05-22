package org.example.vehiculossiniestros.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String patente;
    String marca;
    String modelo;
    @Column(name = "anio_de_fabricacion")
    int anioDeFabricacion;
    @Column(name = "cantidad_de_ruedas")
    int cantidadDeRuedas;
    @OneToMany(mappedBy = "vehiculo")
    Set<Siniestro> siniestros;
}