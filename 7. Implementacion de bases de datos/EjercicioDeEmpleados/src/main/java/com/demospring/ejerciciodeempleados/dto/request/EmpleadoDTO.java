package com.demospring.ejerciciodeempleados.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmpleadoDTO {
    private String nombre;
    private String apellido;
    private int edad;
    private String ciudad;
    private String provincia;
}
