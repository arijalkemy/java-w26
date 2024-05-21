package org.example.es_hib_empleados.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpleadoDto {
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String estado;
}
