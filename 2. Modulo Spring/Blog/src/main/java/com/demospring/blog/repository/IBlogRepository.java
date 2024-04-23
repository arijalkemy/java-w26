package com.demospring.blog.repository;

import com.demospring.blog.model.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    void addEntrada(EntradaBlog entrada);
    EntradaBlog getEntrada(int id);
    List<EntradaBlog> getEntradas();
}
