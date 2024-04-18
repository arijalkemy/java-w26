package com.example.blog.repository;

import com.example.blog.entity.EntradaBlog;

import java.util.List;

public interface IEntradaBlogRepository {

    public void guardarEntradas(EntradaBlog entradaBlog);

    public List<EntradaBlog> getEntradas();

    public EntradaBlog getEntrada(int id);
}
