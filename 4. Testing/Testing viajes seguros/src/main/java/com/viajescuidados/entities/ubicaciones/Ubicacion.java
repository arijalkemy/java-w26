package com.viajescuidados.entities.ubicaciones;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Ubicacion {
    private String direccion;
    private Long latitud;
    private Long longitud;
}
