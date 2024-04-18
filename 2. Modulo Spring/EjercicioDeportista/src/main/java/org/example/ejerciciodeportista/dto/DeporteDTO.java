package org.example.ejerciciodeportista.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DeporteDTO {
    private String nombreDeporte;
    private int nivel;
}
