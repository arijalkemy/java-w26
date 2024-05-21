package org.example.empleados.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EmpleadoResponseDTO {

    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private String ciudad;
    private String provincia;

}
