package org.example.ejercicioblog.repository;

import org.example.ejercicioblog.entity.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    public void addBlog(EntradaBlog blog);
    public List<EntradaBlog> findAll();
    public EntradaBlog findById(int id);
}
