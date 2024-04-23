package org.bootcamp.blog.controller;

import org.bootcamp.blog.dto.BlogDTO;
import org.bootcamp.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired private IBlogService blogService;

    @PostMapping("/blog")
    public String createBlog(@RequestBody BlogDTO blogDTO) {
        return blogService.createBlog(blogDTO);
    }

    @GetMapping("/blog/{id}")
    public BlogDTO getBlog(@PathVariable int id) {
        return blogService.getBlog(id);
    }

    @GetMapping("/blog")
    public List<BlogDTO> getBlogs() {
        return blogService.getBlogs();
    }
}
