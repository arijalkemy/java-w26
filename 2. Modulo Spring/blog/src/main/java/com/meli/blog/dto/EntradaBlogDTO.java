package com.meli.blog.dto;

import lombok.Getter;

@Getter
public class EntradaBlogDTO {
    private String titulo;
    private String autor;
    private String fechaPublicacion;

    public EntradaBlogDTO() {
    }

    public EntradaBlogDTO(String titulo, String autor, String fechaPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }
}
