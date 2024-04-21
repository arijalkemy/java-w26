package com.example.ejercicio_manejo_de_excepciones_p1_vivo.repository;

import com.example.ejercicio_manejo_de_excepciones_p1_vivo.entity.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    public List<EntradaBlog> findAllBlogs();
    public EntradaBlog findBlogById(int id);
    public int create(EntradaBlog blog);
    public boolean blogExists(int id);
}
