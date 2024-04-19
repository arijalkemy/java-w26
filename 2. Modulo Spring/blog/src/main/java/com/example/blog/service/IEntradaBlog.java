package com.example.blog.service;

import com.example.blog.model.EntradaBlog;

import java.util.List;

public interface IEntradaBlog {

    Integer crearBlog(EntradaBlog entradaBlog);
    EntradaBlog obtenerBlog(Integer id);
    List<EntradaBlog> obtenerTodos();
}
