package org.example.lasperlas.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObtenerJoyaResponseDTO {
    Long Id;
    String nombre;
    String material;
    Double peso;
    String particularidad;
    Boolean posee_piedra;
    Boolean ventaONo;
}
