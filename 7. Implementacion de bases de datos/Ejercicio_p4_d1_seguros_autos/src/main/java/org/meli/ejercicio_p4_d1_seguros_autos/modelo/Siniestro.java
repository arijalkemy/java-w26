package org.meli.ejercicio_p4_d1_seguros_autos.modelo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "siniestros")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_siniestro;

    @Column(name = "fecha_siniestro", nullable = false)
    private LocalDate fecha_siniestro;

    @Column(name = "perdida_economica", nullable = false)
    private Double perdida_economica;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Vehiculo vehiculo;

}
