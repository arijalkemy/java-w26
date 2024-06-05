package org.meli.ejercicio_p4_d1_seguros_autos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class VehiculoPatenteMarcaDto {
    private String patente;
    private String marca;
}
