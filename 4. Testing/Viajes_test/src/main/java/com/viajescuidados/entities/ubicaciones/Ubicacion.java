package com.viajescuidados.entities.ubicaciones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ubicacion {
    private String direccion;
    private Long latitud;
    private Long longitud;
}
