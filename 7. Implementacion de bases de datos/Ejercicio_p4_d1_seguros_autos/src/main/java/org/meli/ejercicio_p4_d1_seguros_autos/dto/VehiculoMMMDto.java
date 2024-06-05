package org.meli.ejercicio_p4_d1_seguros_autos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class VehiculoMMMDto {
    private String matricula;
    private String marca;
    private String modelo;
}
