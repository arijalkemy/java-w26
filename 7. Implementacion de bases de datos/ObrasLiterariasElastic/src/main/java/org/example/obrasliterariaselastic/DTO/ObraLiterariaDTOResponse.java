package org.example.obrasliterariaselastic.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ObraLiterariaDTOResponse {
    private String id;

    private String nombre;

    private String autor;

    private Integer cantidadDePaginas;

    private String editorial;

    private Integer anioPrimeraPublicacion;
}
