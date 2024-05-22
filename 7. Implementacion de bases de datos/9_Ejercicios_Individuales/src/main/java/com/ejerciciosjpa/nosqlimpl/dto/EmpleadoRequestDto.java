package com.ejerciciosjpa.nosqlimpl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoRequestDto {
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String division;
}
