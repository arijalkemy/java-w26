package org.example.exceptions_p1_yt_blog.controller;

import org.example.exceptions_p1_yt_blog.dto.BlogDTO;
import org.example.exceptions_p1_yt_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<String> publicBlog(@RequestBody BlogDTO blogEntryDto ){
        int blogId = blogService.save( blogEntryDto );
        return new ResponseEntity<>( "Blog created ID: " + blogId, HttpStatus.CREATED );
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> publicBlog( @PathVariable int id ){
        return new ResponseEntity<>( blogService.findById(id), HttpStatus.OK );
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> publicBlogList(){
        return new ResponseEntity<>( blogService.getAll(), HttpStatus.OK );
    }
}
