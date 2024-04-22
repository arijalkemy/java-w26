package com.ejerciciorest.blog.repositories;

import com.ejerciciorest.blog.entities.EntradaBlog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IRepositorioBlog {
    public Integer agregarBlog(EntradaBlog blog);

    public Map<Integer, EntradaBlog> listaBlogs();

    public EntradaBlog blogPorID(Integer id);


}
