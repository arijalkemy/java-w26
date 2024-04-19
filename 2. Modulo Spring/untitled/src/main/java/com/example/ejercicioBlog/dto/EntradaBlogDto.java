package com.example.ejercicioBlog.dto;

import com.example.ejercicioBlog.model.EntradaBlog;
import lombok.Getter;

@Getter
public class EntradaBlogDto {
    final private String titulo;

    public EntradaBlogDto(EntradaBlog entradaBlog ) {
        this.titulo = entradaBlog.getTitulo();
    }
}
