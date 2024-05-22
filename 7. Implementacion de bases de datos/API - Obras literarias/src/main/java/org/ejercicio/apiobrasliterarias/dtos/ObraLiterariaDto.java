package org.ejercicio.apiobrasliterarias.dtos;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ObraLiterariaDto {
    private String id;
    private String nombre;
    private String autor;
    private Integer cantidadDePaginas;
    private String editorial;
    private Integer anioPrimeraPublicacion;
}
