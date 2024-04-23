package com.example.BlogAnotation.repository.impl;

import com.example.BlogAnotation.entity.EntradaBlog;
import com.example.BlogAnotation.repository.IRepoBD;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepoBD implements IRepoBD {
    List<EntradaBlog> blogs = new ArrayList<>();

    @Override
    public String crearEntradaBlog(EntradaBlog entradaBlog) {
        blogs.add(entradaBlog);
        return "Nueva Entrada: Se ha creado con exito!!!";
    }

    @Override
    public EntradaBlog obtenerBlogPorId(int id) {
        return blogs.stream().filter(blog -> blog.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<EntradaBlog> obtenerTodosBlogs() {
        return blogs;
    }
}
