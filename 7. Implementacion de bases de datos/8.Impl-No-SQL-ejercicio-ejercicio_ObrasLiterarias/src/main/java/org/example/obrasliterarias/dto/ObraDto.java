package org.example.obrasliterarias.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ObraDto {
    private String id;
    private String nombre;
    private String autor;
    private Integer paginas;
    private String editorial;
    private int ano;
}
