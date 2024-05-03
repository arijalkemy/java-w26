package com.viajescuidados.entities;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Persona {
    private Integer id;
    private String nombre;
    private String apellido;
}
