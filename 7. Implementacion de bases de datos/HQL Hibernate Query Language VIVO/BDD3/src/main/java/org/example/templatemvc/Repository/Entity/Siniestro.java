package org.example.templatemvc.Repository.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "perdida")
    private Double perdida;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;

}
