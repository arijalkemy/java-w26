package org.example.ejercicio_blog.repositorios;

import org.example.ejercicio_blog.dtos.BlogDTO;
import org.example.ejercicio_blog.modelos.EntradaBlog;

import java.time.LocalDate;
import java.util.*;

public class BlogRepositorio implements IBlogRepositorio {
    private List<EntradaBlog> entradasBlog = new ArrayList<>();


    @Override
    public List<EntradaBlog> obtenerTodos() {
        return entradasBlog;
    }

    @Override
    public EntradaBlog obtenerPorId(Long id) {
        EntradaBlog entradaBlog = null;
        entradaBlog = this.entradasBlog.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
        return entradaBlog;
    }

    @Override
    public EntradaBlog crear(BlogDTO entradaBlog) {
        EntradaBlog nuevaEntradaBlog = new EntradaBlog(entradaBlog.getId(),entradaBlog.getTitulo(),entradaBlog.getNombreAutor(), entradaBlog.getFechaPublicacion());
        this.entradasBlog.add(nuevaEntradaBlog);
        return nuevaEntradaBlog;
    }
}
