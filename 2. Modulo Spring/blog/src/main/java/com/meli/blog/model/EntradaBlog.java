package com.meli.blog.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class EntradaBlog {
    private String Id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;

    public EntradaBlog() {
    }

    public EntradaBlog(String titulo, String autor, LocalDate fechaPublicacion) {
        Id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }
}
