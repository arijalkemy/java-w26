package com.example.ejercicio_implementacion_nosql_empleados.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoResponseDto {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String localidad;
}
