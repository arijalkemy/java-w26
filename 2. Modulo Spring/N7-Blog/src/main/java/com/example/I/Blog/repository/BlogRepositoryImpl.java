package com.example.I.Blog.repository;

import com.example.I.Blog.entity.EntradaBlog;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@Repository
public class BlogRepositoryImpl implements  IBlogRepository{

    List<EntradaBlog> entradaBlogs;

    public BlogRepositoryImpl(List<EntradaBlog> entradaBlogs) {
        this.entradaBlogs = entradaBlogs;
    }

}
