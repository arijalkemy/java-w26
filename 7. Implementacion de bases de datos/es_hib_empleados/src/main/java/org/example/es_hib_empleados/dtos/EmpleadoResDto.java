package org.example.es_hib_empleados.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoResDto {
    private String id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String estado;
}
