package com.viajescuidados.dtos;

import lombok.*;

@EqualsAndHashCode
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UbicacionDTO {
    private String direccion;
    private Long latitud;
    private Long longitud;
}
