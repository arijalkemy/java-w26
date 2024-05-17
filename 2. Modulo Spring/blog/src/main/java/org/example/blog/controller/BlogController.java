package org.example.blog.controller;


import org.example.blog.dto.BlogByIdDTO;
import org.example.blog.dto.BlogDTO;
import org.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    IBlogService blogService;

    @PostMapping("/blog")
    public BlogByIdDTO blog(@RequestBody BlogDTO blog) {
        return blogService.saveBlog(blog);
    }

    @GetMapping("/blog/{id}")
    public BlogDTO blog(@PathVariable Long id) {
        return blogService.getBlogById(id);
    }

    @GetMapping("/blogs")
    public List<BlogDTO> blogsAll() {
        return blogService.blogsAll();
    }
}
