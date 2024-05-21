package org.example.vehiculos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    @Column(name = "anio_de_fabricacion")
    private Integer anioDeFabricacion;
    @Column(name = "cantidad_de_ruedas")
    private Integer cantidadDeRuedas;
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Siniestro> siniestros;
}
