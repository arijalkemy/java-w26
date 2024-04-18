package org.example.blog.controller;

import org.example.blog.dto.BlogRequestDTO;
import org.example.blog.dto.BlogResponseDTO;
import org.example.blog.exceptions.blog.BlogAlreadyExistException;
import org.example.blog.exceptions.blog.BlogNotFoundExcpetion;
import org.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogResponseDTO>>getAllBlogs(){
        List<BlogResponseDTO> blogs = blogService.getAllBlog();
        if(blogs.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(blogs);
    }

    @PostMapping("/blog")
    public ResponseEntity<Integer> addBlog(@RequestBody BlogRequestDTO blogRequestDTO){
        return ResponseEntity.ok(blogService.addBlog(blogRequestDTO));
    }

    @GetMapping("blog/{id}")
    public ResponseEntity<BlogResponseDTO> getBlogById(@PathVariable("id") int id){
        BlogResponseDTO blog = blogService.getBlog(id);
        if(blog == null){
            throw new BlogNotFoundExcpetion("El blog no existe");
        }
        return ResponseEntity.ok(blog);
    }
}
