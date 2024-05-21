package com.meli.Empleados.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmpleadoDto {
    private String nombre;
    private String apellido;
    private int edad;
    private String ciudad;
    private String provincia;
    private String estado;
    private String departamento;
}
