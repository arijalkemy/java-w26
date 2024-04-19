package org.ejercicio.blog.entity;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EntradaBlog {
    private int id;
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion = LocalDate.now();

    public EntradaBlog(int id, String titulo, String nombreAutor) {
        this.id = id;
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
    }
}
