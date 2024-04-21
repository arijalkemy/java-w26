package com.example.ejercicio_manejo_de_excepciones_p1_vivo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BlogDto {
    private int id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
