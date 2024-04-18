package com.example.excepciones_blog.service.BlogService.impl;

import com.example.excepciones_blog.dto.BlogDto;
import com.example.excepciones_blog.entities.EntradaBlog;
import com.example.excepciones_blog.exceptions.AlreadyExistException;
import com.example.excepciones_blog.exceptions.NotFoundException;
import com.example.excepciones_blog.repository.BlogRepository.IBlogRepository;
import com.example.excepciones_blog.service.BlogService.IBlogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    IBlogRepository blogRepository;

    @Override
    public void createBlog(BlogDto blogDto) {
        EntradaBlog blog = blogRepository.findById(blogDto.getId());
        if (blog != null){
            throw new AlreadyExistException("El ID ya existe");
        } else {
            blogRepository.createBlog(mapToEntity(blogDto));
        }
    }

    @Override
    public BlogDto getBlog(UUID id) {
        EntradaBlog blog = blogRepository.findById(id);
        if (blog == null){
            throw new NotFoundException("No se encontró el libro");
        }
        return mapToDto(blog);
    }

    @Override
    public List<BlogDto> getAllBlogs() {
        List<BlogDto> blogsDto = blogRepository.findAll().stream().map(this::mapToDto).toList();
        return blogsDto;
    }

    private EntradaBlog mapToEntity(BlogDto blogDto){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(blogDto, EntradaBlog.class);
    }

    private BlogDto mapToDto(EntradaBlog blog){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(blog, BlogDto.class);
    }
}
