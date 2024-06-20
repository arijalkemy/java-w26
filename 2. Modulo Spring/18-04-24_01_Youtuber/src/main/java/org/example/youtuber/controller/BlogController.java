package org.example.youtuber.controller;

import org.example.youtuber.dto.BlogDTO;
import org.example.youtuber.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    public String createBlog(@RequestBody BlogDTO blogDTO) {
        BlogDTO createdBlog = blogService.createBlog(blogDTO);
        return "Blog with id " + createdBlog.getId() + " created successfully";
    }

    @GetMapping("/{id}")
    public BlogDTO getBlogById(@PathVariable Integer id) {
        return blogService.getBlogById(id);
    }

    @GetMapping
    public List<BlogDTO> getAllBlogs() {
        return blogService.getAllBlogs();
    }
}
