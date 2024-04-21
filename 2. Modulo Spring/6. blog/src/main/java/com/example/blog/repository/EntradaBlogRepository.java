package com.example.blog.repository;

import com.example.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaBlogRepository {

    private List<EntradaBlog> blogs = new ArrayList<>();

    public Integer crearBlog(EntradaBlog entradaBlog){
        this.blogs.add(entradaBlog);
        return entradaBlog.getId();
    }

    public EntradaBlog obtenerBlog(Integer id){
        return blogs.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
    }

    public List<EntradaBlog> obtenerTodos(){
        return this.blogs;
    }
}
