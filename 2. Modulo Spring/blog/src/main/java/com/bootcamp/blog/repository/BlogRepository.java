package com.bootcamp.blog.repository;

import com.bootcamp.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository {

    private final List<EntradaBlog> listEntradasBlog;

    public BlogRepository(){
        listEntradasBlog = new ArrayList<>();
    }

    public List<EntradaBlog> getAll(){
        return listEntradasBlog;
    }

    public EntradaBlog getById(int id){

        EntradaBlog entradaBlog = listEntradasBlog.stream().filter( e -> e.getId() == id).findFirst().orElse(null);

        if(entradaBlog == null) {return null;}

        return entradaBlog;

    }


    //Consultar donde se debe validar si existe - Delegar esa responsabilidad al servicio o al repositorio?

    public EntradaBlog create(EntradaBlog entradaBlog){

        listEntradasBlog.add(entradaBlog);

        return entradaBlog;
    }

    public boolean existeEntrada(int id){

        return listEntradasBlog.stream().anyMatch( e -> e.getId() == id);
    }


}
