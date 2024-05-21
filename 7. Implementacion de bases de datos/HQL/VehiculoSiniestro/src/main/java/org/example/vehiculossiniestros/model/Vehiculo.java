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
    int anioDeFabricacion;
    int cantidadDeRuedas;
    @OneToMany(mappedBy = "vehiculo")
    Set<Siniestro> siniestros;
}