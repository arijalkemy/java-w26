package org.ggomezr.deportistas.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private String nombreDeporte;
}
