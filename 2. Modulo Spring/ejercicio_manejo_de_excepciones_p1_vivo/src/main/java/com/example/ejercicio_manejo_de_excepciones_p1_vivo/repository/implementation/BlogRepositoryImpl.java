package com.example.ejercicio_manejo_de_excepciones_p1_vivo.repository.implementation;

import com.example.ejercicio_manejo_de_excepciones_p1_vivo.entity.EntradaBlog;
import com.example.ejercicio_manejo_de_excepciones_p1_vivo.exception.NotFoundException;
import com.example.ejercicio_manejo_de_excepciones_p1_vivo.repository.IBlogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {
    private List<EntradaBlog> entradasBlog;

    public BlogRepositoryImpl() {
        entradasBlog = new ArrayList<>();
    }

    @Override
    public List<EntradaBlog> findAllBlogs() {
        return entradasBlog;
    }

    @Override
    public EntradaBlog findBlogById(int id) {
        return entradasBlog.stream().filter(e -> e.getId() == id).findFirst().orElseThrow(
            () -> new NotFoundException("Blog", Integer.toString(id))
        );
    }

    @Override
    public int create(EntradaBlog blog) {
        entradasBlog.add(blog);
        return blog.getId();
    }

    @Override
    public boolean blogExists(int id) {
        return entradasBlog.stream().anyMatch(e -> e.getId() == id);
    }
}
