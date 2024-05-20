package org.example.joyas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.joyas.enums.Material;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JewelRequestDTO {
    private String nombre;
    private Material material;
    private Double peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean ventaONo;
}
