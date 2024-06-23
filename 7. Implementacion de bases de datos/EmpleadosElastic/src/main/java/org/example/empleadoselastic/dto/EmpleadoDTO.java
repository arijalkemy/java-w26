package org.example.empleadoselastic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTO {
    private String id;
    private String nombre;
    private String apellido;
    private Long edad;
    private String ciudad;
    private String departamento;
}
