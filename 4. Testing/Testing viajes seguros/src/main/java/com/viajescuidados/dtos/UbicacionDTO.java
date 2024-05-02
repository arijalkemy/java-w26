package com.viajescuidados.dtos;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class UbicacionDTO {
    private String direccion;
    private Long latitud;
    private Long longitud;
}
