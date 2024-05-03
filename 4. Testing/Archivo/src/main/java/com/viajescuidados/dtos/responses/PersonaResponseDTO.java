package com.viajescuidados.dtos.responses;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PersonaResponseDTO {
    private Integer id;
    private String nombre;
    private String apellido;
}
