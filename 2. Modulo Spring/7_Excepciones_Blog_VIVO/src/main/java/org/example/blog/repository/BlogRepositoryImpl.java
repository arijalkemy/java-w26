package org.example.blog.repository;

import org.example.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {

    List<EntradaBlog> entradasBlog;

    public BlogRepositoryImpl() {
        entradasBlog = new ArrayList<>();
    }


    @Override
    public List<EntradaBlog> buscarTodos() {
        return entradasBlog;
    }

    @Override
    public Optional<EntradaBlog> buscarPorId(int id) {
        return entradasBlog.stream()
            .filter(eb -> eb.getId() == id)
            .findFirst();
    }

    @Override
    public void guardar(EntradaBlog entradaBlog) {
        entradasBlog.add(entradaBlog);
    }
}
