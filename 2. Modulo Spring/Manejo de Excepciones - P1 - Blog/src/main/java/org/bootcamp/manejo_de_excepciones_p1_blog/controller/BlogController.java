package org.bootcamp.manejo_de_excepciones_p1_blog.controller;

import org.bootcamp.manejo_de_excepciones_p1_blog.dto.BlogDTO;
import org.bootcamp.manejo_de_excepciones_p1_blog.dto.RequestBlogDTO;
import org.bootcamp.manejo_de_excepciones_p1_blog.dto.ResponseBlogDTO;
import org.bootcamp.manejo_de_excepciones_p1_blog.entity.Blog;
import org.bootcamp.manejo_de_excepciones_p1_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    ResponseEntity<List<BlogDTO>> getBlogs() {
        return ResponseEntity.ok(blogService.getBlogs());
    }

    @GetMapping("/{id}")
    ResponseEntity<BlogDTO> getBlogsById(@PathVariable Integer id) {
        return ResponseEntity.ok(blogService.getBlog(id));
    }

    @PostMapping
    ResponseEntity<ResponseBlogDTO> postBlog(@RequestBody RequestBlogDTO blog) {
        return ResponseEntity.ok(blogService.addBlog(blog));
    }

}
