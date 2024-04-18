package com.ejercicio.manejodeblogs.controller;

import com.ejercicio.manejodeblogs.DTO.BlogEntryRequestDTO;
import com.ejercicio.manejodeblogs.entity.BlogEntry;
import com.ejercicio.manejodeblogs.service.interfaces.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @PostMapping
    public String addBlogEntry(@RequestBody BlogEntry blogEntry) {
        return blogService.addBlog(blogEntry);
    }

    @GetMapping
    public BlogEntry getBlogEntry(@RequestParam int id) {
        return blogService.getBlogById(id);
    }

    @GetMapping("/getAll")
    public List<BlogEntry> getAllBogEntries() {
        return blogService.getAllBlogs();
    }
}
