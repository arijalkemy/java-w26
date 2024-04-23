package com.example.BlogAnotation.repository;

import com.example.BlogAnotation.entity.EntradaBlog;

import java.util.List;

public interface IRepoBD {
    public String crearEntradaBlog(EntradaBlog entradaBlog);

    public EntradaBlog obtenerBlogPorId(int id);

    public List<EntradaBlog> obtenerTodosBlogs();
}
