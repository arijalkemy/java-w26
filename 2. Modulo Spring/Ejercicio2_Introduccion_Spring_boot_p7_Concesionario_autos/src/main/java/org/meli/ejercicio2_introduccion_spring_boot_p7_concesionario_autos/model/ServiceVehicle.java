package org.meli.ejercicio2_introduccion_spring_boot_p7_concesionario_autos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceVehicle {
    private String date;
    private Double kilometers;
    private String descriptions;
}
