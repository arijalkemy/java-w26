package org.ejercicio.blog.repository;

import org.ejercicio.blog.entity.EntradaBlog;

import java.util.List;

public interface IEntradaBlogRepository {
    List<EntradaBlog> buscarTodos();
    EntradaBlog buscarPorId(int id);
    void agregarBlog(EntradaBlog entradaBlog);
}
