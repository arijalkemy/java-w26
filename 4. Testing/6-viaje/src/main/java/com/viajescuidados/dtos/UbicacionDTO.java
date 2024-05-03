package com.viajescuidados.dtos;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UbicacionDTO {
    private String direccion;
    private Long latitud;
    private Long longitud;
}
