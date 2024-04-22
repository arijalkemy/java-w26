package com.ejerciciorest.blog.repositories;

import com.ejerciciorest.blog.entities.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepositorioBlogImpl implements IRepositorioBlog{

    private static Map<Integer, EntradaBlog> listaBlogs = new HashMap<>();

    @Override
    public Integer agregarBlog(EntradaBlog blog) {
        listaBlogs.put(blog.getId(), blog);
        return blog.getId();
    }

    @Override
    public Map<Integer, EntradaBlog> listaBlogs() {
        return listaBlogs;
    }

    @Override
    public EntradaBlog blogPorID(Integer id) {
        return listaBlogs.get(id);
    }


}
