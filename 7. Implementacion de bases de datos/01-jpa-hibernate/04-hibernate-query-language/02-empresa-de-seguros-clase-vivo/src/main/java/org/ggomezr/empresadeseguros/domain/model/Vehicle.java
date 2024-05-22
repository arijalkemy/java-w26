package org.ggomezr.empresadeseguros.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String patent;
    private String brand;
    private String model;

    @Column(name = "fabrication_year")
    private Integer fabricationYear;

    @Column(name = "number_of_wheels")
    private Integer numberOfWheels;

    @OneToMany(mappedBy = "reportedVehicle", cascade = CascadeType.ALL)
    private List<Sinister> sinisters;
}
