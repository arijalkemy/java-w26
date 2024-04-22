package com.bootcamp.blog.service;

import com.bootcamp.blog.entity.EntradaBlog;

import java.util.HashMap;

public interface IBlogService {
    EntradaBlog crearEntrada(EntradaBlog entradaBlog);
    EntradaBlog obtenerEntrada(Integer id);
    HashMap<Integer, EntradaBlog> obtenerEntradas();
}

