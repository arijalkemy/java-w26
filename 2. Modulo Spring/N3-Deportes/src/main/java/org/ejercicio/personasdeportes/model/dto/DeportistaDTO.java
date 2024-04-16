package org.ejercicio.personasdeportes.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class DeportistaDTO implements Serializable {
    private String nombre;
    private String apellido;
    private String nombreDeporte;
}
