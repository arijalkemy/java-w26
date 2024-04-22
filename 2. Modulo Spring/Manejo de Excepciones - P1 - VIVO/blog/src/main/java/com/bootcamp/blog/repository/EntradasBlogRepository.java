package com.bootcamp.blog.repository;

import com.bootcamp.blog.controller.BlogController;
import com.bootcamp.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Repository
public class EntradasBlogRepository {
    public HashMap<Integer, EntradaBlog> entradas = new HashMap<>();;


    public EntradaBlog save(EntradaBlog entrada){
        entradas.put(entrada.getId(), entrada);
        return entrada;
    }

    public EntradaBlog findById(Integer id){
        return entradas.get(id);
    }

    public boolean existsById(Integer id){
        return entradas.containsKey(id);
    }

    public HashMap<Integer, EntradaBlog> findAll(){
        return entradas;
    }
}
