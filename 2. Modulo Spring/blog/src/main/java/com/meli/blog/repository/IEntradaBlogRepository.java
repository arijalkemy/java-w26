package com.meli.blog.repository;

import com.meli.blog.model.EntradaBlog;

import java.util.List;

public interface IEntradaBlogRepository {
    void save(EntradaBlog entradaBlog);

    EntradaBlog buscarPorId(String id);

    List<EntradaBlog> getAll();
}
