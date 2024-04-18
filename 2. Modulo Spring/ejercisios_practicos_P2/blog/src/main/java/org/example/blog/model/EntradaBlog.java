package org.example.blog.model;

import lombok.Data;
import lombok.Getter;
import org.example.blog.dto.BlogRequestDTO;


import java.time.LocalDate;

@Data
public class EntradaBlog {
    private int id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;

    public EntradaBlog(BlogRequestDTO blog) {
        this.id = blog.getId();
        this.titulo = blog.getTitulo();
        this.autor = blog.getAutor();
        this.fechaPublicacion = blog.getFechaPublicacion();
    }
}
