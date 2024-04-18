package org.example.blog.dto;

import lombok.Getter;
import org.example.blog.model.EntradaBlog;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
public class BlogResponseDTO implements Serializable {
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;

    public BlogResponseDTO() {
    }

    public BlogResponseDTO(EntradaBlog blog) {
        this.titulo = blog.getTitulo();
        this.autor = blog.getAutor();
        this.fechaPublicacion = blog.getFechaPublicacion();
    }}
