package org.ejercicio.apiobrasliterarias.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ObraLiterariaRequestDto {
    private String nombre;
    private String autor;
    private Integer cantidadDePaginas;
    private String editorial;
    @JsonFormat(pattern = "yyyy")
    private Integer anioPrimeraPublicacion;
}
