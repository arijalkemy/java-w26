package com.example.excepciones_blog.repository.BlogRepository.impl;

import com.example.excepciones_blog.entities.EntradaBlog;
import com.example.excepciones_blog.repository.BlogRepository.IBlogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {

    private List<EntradaBlog> blogs = new ArrayList<>();
    @Override
    public void createBlog(EntradaBlog entradaBlog) {
        blogs.add(entradaBlog);
    }

    @Override
    public EntradaBlog findById(UUID id) {
        return blogs.stream().filter(blog -> blog.getId().equals(id)).findAny().orElse(null);
    }

    @Override
    public List<EntradaBlog> findAll() {
        return blogs;
    }
}

