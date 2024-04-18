package com.example.excepciones_blog.repository.BlogRepository;

import com.example.excepciones_blog.dto.BlogDto;
import com.example.excepciones_blog.entities.EntradaBlog;

import java.util.List;
import java.util.UUID;

public interface IBlogRepository{
    void createBlog(EntradaBlog entradaBlog);
    EntradaBlog findById(UUID id);
    List<EntradaBlog> findAll();
}
