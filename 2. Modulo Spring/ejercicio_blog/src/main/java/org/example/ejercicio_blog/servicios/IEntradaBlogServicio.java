package org.example.ejercicio_blog.servicios;

import org.example.ejercicio_blog.dtos.BlogDTO;

import java.util.*;

public interface IEntradaBlogServicio {
    public BlogDTO crearEntrada(BlogDTO entradaDTO);
    public BlogDTO obtenerPorID(Long id);
    public List<BlogDTO> obtenerTodos();
}
