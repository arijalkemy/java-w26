package com.youtube.blog.entity;

import lombok.Data;

@Data
public class EntradaBlog {
    private int id;
    private String titulo;
    private String nombreDelAutor;
    private String fechaDePublicacion;

    public EntradaBlog(int id, String titulo, String nombreDelAutor, String fechaDePublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.nombreDelAutor = nombreDelAutor;
        this.fechaDePublicacion = fechaDePublicacion;
    }
}
