package com.ejercicio.manejodeblogs.repository.interfaces;

import com.ejercicio.manejodeblogs.entity.BlogEntry;

import java.util.List;

public interface IBlogRepository {
    public BlogEntry add(BlogEntry blogEntry);
    public BlogEntry getById(int id);
    public List<BlogEntry> getAll();
}
