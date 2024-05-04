package com.viajescuidados.entities.ubicaciones;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Ubicacion {
    private String direccion;
    private Long latitud;
    private Long longitud;
}
