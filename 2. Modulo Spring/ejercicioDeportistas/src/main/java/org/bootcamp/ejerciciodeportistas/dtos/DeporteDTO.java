package org.bootcamp.ejerciciodeportistas.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeporteDTO {
    private String nombre;
    private int nivel;
}
