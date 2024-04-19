package org.example.blog.repository.impl;

import org.example.blog.dto.BlogDTO;
import org.example.blog.model.EntradaBlog;
import org.example.blog.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaBlogRepository implements IRepository {

    List<EntradaBlog> listEntradaBlog;

    public EntradaBlogRepository() {
        listEntradaBlog = new ArrayList<>();
    }

    public boolean exist(int id) {
        return listEntradaBlog.stream().anyMatch(b -> b.getId() == id);
    }

    @Override
    public int add(EntradaBlog blog) {
        listEntradaBlog.add(blog);
        return blog.getId();
    }

    @Override
    public EntradaBlog getById(int id) {
        return listEntradaBlog.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<EntradaBlog> getAll() {
        return listEntradaBlog;
    }
}
