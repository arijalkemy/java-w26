package org.ggomezr.empresadeseguros.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sinisters")
public class Sinister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate sinisterDate;
    private Double economicLoss;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle reportedVehicle;
}
