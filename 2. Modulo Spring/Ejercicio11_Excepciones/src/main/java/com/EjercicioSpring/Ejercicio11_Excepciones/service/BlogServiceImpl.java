package com.EjercicioSpring.Ejercicio11_Excepciones.service;

import com.EjercicioSpring.Ejercicio11_Excepciones.dto.BlogDTO;
import com.EjercicioSpring.Ejercicio11_Excepciones.entity.Blog;
import com.EjercicioSpring.Ejercicio11_Excepciones.repository.IBlogRepository;
import com.EjercicioSpring.Ejercicio11_Excepciones.service.interfaces.IBlogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    IBlogRepository blogRepository;
    ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Override
    public boolean crearLibro(BlogDTO blogDTO) {
        Blog blog = objectMapper.convertValue(blogDTO, Blog.class);
        return blogRepository.crearBlog(blog);
    }

    @Override
    public BlogDTO obtenerLibroPorId(Long id) {
        Blog blog = blogRepository.obtenerBlogPorID(id);
        if (blog == null) {
            return null;
        }
        return objectMapper.convertValue(blog, BlogDTO.class);
    }

    @Override
    public List<BlogDTO> obtenerBlogs() {
        List<Blog> blogs = blogRepository.obtenerBlogs();
        System.out.println(blogs);
        return blogs.stream().map(x -> objectMapper.convertValue(x, BlogDTO.class)).toList();
    }
}
