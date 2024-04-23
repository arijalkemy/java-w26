package com.demospring.blog.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EntradaBlog {
    private int id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;

    public EntradaBlog(int id, String titulo, String nombreAutor, String fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
    }
}
