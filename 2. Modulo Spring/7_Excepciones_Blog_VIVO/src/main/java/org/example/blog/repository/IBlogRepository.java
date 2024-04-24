package org.example.blog.repository;

import org.example.blog.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {
    List<EntradaBlog> buscarTodos();
    Optional<EntradaBlog> buscarPorId(int id);
    void guardar(EntradaBlog entradaBlog);
}
