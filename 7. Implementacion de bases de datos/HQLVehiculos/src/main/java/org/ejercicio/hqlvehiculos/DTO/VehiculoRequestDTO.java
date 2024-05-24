package org.ejercicio.hqlvehiculos.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoRequestDTO {
    private String Patente;

    private String Marca;

    private String Modelo;

    private LocalDate fechaFabricacion;

    private Integer cantidadDeRuedas;

}
