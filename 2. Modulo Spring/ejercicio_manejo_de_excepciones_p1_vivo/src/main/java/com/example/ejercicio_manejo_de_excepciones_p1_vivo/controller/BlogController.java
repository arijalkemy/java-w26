package com.example.ejercicio_manejo_de_excepciones_p1_vivo.controller;

import com.example.ejercicio_manejo_de_excepciones_p1_vivo.dto.BlogDto;
import com.example.ejercicio_manejo_de_excepciones_p1_vivo.dto.ResponseDto;
import com.example.ejercicio_manejo_de_excepciones_p1_vivo.service.IBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogController {
    private final IBlogService blogService;

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDto>> getAllBlogs() {
        return ResponseEntity.ok().body(
                blogService.searchAllBlogs()
        );
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<BlogDto> getBlog(
            @PathVariable int id
    ) {
        return ResponseEntity.ok().body(
                blogService.searchBlog(id)
        );
    }

    @PostMapping("/blog")
    public ResponseEntity<ResponseDto> createBlog(
        @RequestBody BlogDto blog
    ) {
        int id = blogService.createBlog(blog);
        return new ResponseEntity<>(
            new ResponseDto("Blog creado con ID: " + Integer.toString(id)),
            HttpStatus.CREATED
        );
    }
}
