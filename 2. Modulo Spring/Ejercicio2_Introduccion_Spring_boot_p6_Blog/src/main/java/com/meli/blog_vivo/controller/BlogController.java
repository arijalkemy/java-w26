package com.meli.blog_vivo.controller;

import com.meli.blog_vivo.dto.BlogDTO;
import com.meli.blog_vivo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @PostMapping
    public ResponseEntity<Integer> postCreateBlog(@RequestBody BlogDTO blog){
        return new ResponseEntity<>(blogService.addBlog(blog), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDTO> getBlogById(@PathVariable Integer id){
        return new ResponseEntity<>(blogService.searchOne(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BlogDTO>> getAllBlogs(){
        return new ResponseEntity<>(blogService.searchAll(), HttpStatus.OK);
    }
}
