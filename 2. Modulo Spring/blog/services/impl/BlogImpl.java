package org.example.blog.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.blog.dto.BlogDto;
import org.example.blog.entities.Blog;
import org.example.blog.exceptions.BlogException;
import org.example.blog.repositories.IBlogRepository;
import org.example.blog.services.IBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogImpl implements IBlog {
    private final IBlogRepository iBlogRepository;
    private final ObjectMapper objectMapper;

    public BlogImpl(@Autowired IBlogRepository iBlogRepository) {
        this.objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        this.iBlogRepository = iBlogRepository;
    }

    @Override
    public Integer saveBlog(BlogDto blogDto) {
        Blog newBlog = this.objectMapper.convertValue(blogDto, Blog.class);
        System.out.println(newBlog);
        if (!this.iBlogRepository.saveBlog(newBlog)) {
            throw new BlogException("Id Duplicated", HttpStatus.CONFLICT);
        }
        return newBlog.getId();
    }

    @Override
    public BlogDto getBlogById(Integer id) {
        Blog blog = this.iBlogRepository.getBlogById(id);
        if (blog == null) {
            throw new BlogException("Id " + id + " Not Found", HttpStatus.NOT_FOUND);
        }
        return this.objectMapper.convertValue(blog, BlogDto.class);
    }

    @Override
    public List<BlogDto> getListBlog() {
        List<Blog> blogs = this.iBlogRepository.getListBlog();
        if (blogs.isEmpty()) {
            throw new BlogException("No Blogs Found", HttpStatus.NOT_FOUND);
        }
        return blogs.stream().map(blog -> this.objectMapper.convertValue(blog, BlogDto.class)).toList();
    }
}
