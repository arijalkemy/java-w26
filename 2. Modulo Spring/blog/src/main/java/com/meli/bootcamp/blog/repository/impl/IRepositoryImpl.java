package com.meli.bootcamp.blog.repository.impl;

import com.meli.bootcamp.blog.model.EntradaBlog;
import com.meli.bootcamp.blog.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class IRepositoryImpl implements IRepository<EntradaBlog> {
    List<EntradaBlog> entradaBlogs;

    public IRepositoryImpl() {
        this.entradaBlogs = new ArrayList<>();
    }

    @Override
    public void add(EntradaBlog entity) {
        entradaBlogs.add(entity);
    }

    @Override
    public List<EntradaBlog> getAll() {
        return entradaBlogs;
    }

    @Override
    public Optional<EntradaBlog> findById(Integer id) {
        return entradaBlogs.stream()
                .filter(e->e.getId().equals(id))
                .findFirst();
    }
}
