package com.mercadolibre.Vehiculos_Sinietros.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "siniestros")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_siniestro;
    private LocalDate fecha_siniestro;
    private Double perdida_económica;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_vehículo_denunciado", nullable = false, referencedColumnName = "id_vehiculo")
    private Vehiculo Id_vehículo_denunciado;
}
