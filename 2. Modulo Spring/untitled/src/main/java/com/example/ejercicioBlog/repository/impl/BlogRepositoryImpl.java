package com.example.ejercicioBlog.repository.impl;

import com.example.ejercicioBlog.dto.EntradaBlogDto;
import com.example.ejercicioBlog.repository.IBlogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {

    Map<Integer, EntradaBlogDto> entradasBlog;

    public BlogRepositoryImpl() {
        entradasBlog = new HashMap<>();
    }

    @Override
    public List<EntradaBlogDto> getAll() {
        return new ArrayList<>(this.entradasBlog.values());
    }

    @Override
    public EntradaBlogDto findById(int id) {

       if( ! this.entradasBlog.containsKey( id )){
           return null;
       }
        return this.entradasBlog.get(id);

    }


    @Override
    public boolean save(int id, EntradaBlogDto entradaBlog) {
        if( this.entradasBlog.containsKey( id )){
            return false;
        }
        this.entradasBlog.put(id, entradaBlog);
        return true;
    }
}
