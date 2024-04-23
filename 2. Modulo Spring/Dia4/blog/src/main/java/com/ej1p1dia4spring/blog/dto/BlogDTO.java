package com.ej1p1dia4spring.blog.dto;

import lombok.Data;

@Data
public class BlogDTO {
    private int id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;

    public BlogDTO(int id, String titulo, String nombreAutor, String fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
    }
}
