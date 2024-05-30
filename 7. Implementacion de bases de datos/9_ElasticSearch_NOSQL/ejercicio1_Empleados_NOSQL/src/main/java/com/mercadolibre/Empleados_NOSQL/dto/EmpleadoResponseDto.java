package com.mercadolibre.Empleados_NOSQL.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmpleadoResponseDto {
    String id;
    String nombre;
    String apellido;
    Integer edad;
    String ciudad;
    String departamento;
}
