package com.youtube.blog.dto;

import com.youtube.blog.entity.EntradaBlog;
import lombok.Data;

import java.util.List;

@Data
public class BlogDTO {
    private int id;
    private String titulo;
    private String nombreDelAutor;
    private String fechaDePublicacion;

    public BlogDTO(EntradaBlog entradaBlog) {
        this.id = entradaBlog.getId();
        this.titulo = entradaBlog.getTitulo();
        this.nombreDelAutor = entradaBlog.getNombreDelAutor();
        this.fechaDePublicacion = entradaBlog.getFechaDePublicacion();
    }
}
