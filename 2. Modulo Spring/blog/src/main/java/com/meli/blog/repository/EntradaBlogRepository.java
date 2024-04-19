package com.meli.blog.repository;

import com.meli.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository{

    private List<EntradaBlog> entradas = new ArrayList<>();

    @Override
    public void save(EntradaBlog entradaBlog) {
        entradas.add(entradaBlog);
    }

    @Override
    public EntradaBlog buscarPorId(String id) {
        return entradas.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<EntradaBlog> getAll() {
        return entradas;
    }
}
