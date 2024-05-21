package com.empleadoselastic.DTOs;

import lombok.Data;

@Data
public class EmpleadoRequestDTO {
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String provincia;
    private String estado;
    private String departamento;
}
