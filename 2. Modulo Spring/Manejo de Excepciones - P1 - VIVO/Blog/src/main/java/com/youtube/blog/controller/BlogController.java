package com.youtube.blog.controller;

import com.youtube.blog.dto.BlogDTO;
import com.youtube.blog.entity.EntradaBlog;
import com.youtube.blog.exceptions.NotFoundException;
import com.youtube.blog.exceptions.RecordAlreadyExistsException;
import com.youtube.blog.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public List<BlogDTO> getBlogs() {
        return blogService.getTodosLosBlogs();
    }

    @GetMapping("/blog/{id}")
    public BlogDTO getBlogPorId(@PathVariable int id) {
        return blogService.getBlogPorId(id);
    }

    @PostMapping("/blog")
    public ResponseEntity<String> agregarBlog(BlogDTO entradaBlog) {

        return blogService.guardarBlog(entradaBlog);
    }
}
