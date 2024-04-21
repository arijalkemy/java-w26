package com.example.ejercicio_manejo_de_excepciones_p1_vivo.service;

import com.example.ejercicio_manejo_de_excepciones_p1_vivo.dto.BlogDto;

import java.util.List;

public interface IBlogService {
    public List<BlogDto> searchAllBlogs();
    public BlogDto searchBlog(int id);
    public int createBlog(BlogDto blog);
}
