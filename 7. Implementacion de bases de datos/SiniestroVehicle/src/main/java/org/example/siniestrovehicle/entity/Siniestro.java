package org.example.siniestrovehicle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Siniestro {
    @Id
    @Column(name = "id_siniestro")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idSiniestro;
    @Column(name = "fecha_siniestro", nullable = false)
    private LocalDate fechaSiniestro;
    @Column(name = "precio_siniestro", nullable = false)
    private Double precioSiniestro;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehiculo_id")
    private Vehicle vehiculo;
}
