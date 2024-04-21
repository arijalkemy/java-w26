package org.example.ejercicio_blog.repositorios;

import org.example.ejercicio_blog.dtos.BlogDTO;
import org.example.ejercicio_blog.modelos.EntradaBlog;

import java.util.*;

public interface IBlogRepositorio {
    public List<EntradaBlog> obtenerTodos();
    public EntradaBlog obtenerPorId(Long id);
    public EntradaBlog crear(BlogDTO entradaBlog);
}
