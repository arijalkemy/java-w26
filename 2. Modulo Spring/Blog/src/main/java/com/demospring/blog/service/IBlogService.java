package com.demospring.blog.service;

import com.demospring.blog.model.EntradaBlog;

import java.util.List;

public interface IBlogService {
    void addEntrada(EntradaBlog entrada);
    EntradaBlog getEntrada(int id);
    List<EntradaBlog> getEntradas();
}
