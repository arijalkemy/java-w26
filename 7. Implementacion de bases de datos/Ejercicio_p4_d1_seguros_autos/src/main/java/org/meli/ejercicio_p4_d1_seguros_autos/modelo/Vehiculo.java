package org.meli.ejercicio_p4_d1_seguros_autos.modelo;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="matricula")
    private String matricula;

    @Column(name = "patente", nullable = false)
    private String patente;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "agno_fabricacion", nullable = false)
    private Integer agno_fabricacion;

    @Column(name = "num_ruedas", nullable = false)
    private Integer num_ruedas;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehiculo")
    private Set<Siniestro> siniestros;
}
