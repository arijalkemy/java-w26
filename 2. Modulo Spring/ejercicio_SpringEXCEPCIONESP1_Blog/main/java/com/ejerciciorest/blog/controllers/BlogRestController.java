package com.ejerciciorest.blog.controllers;

import com.ejerciciorest.blog.dto.EntradaBlogDTO;
import com.ejerciciorest.blog.entities.EntradaBlog;
import com.ejerciciorest.blog.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BlogRestController {

    @Autowired
    private BlogServiceImpl blogService;

    @PostMapping("/blog")
    public ResponseEntity<Integer> postAgregarBlog(@RequestBody EntradaBlog blog){
        return ResponseEntity.ok().body(blogService.agregarBlog(blog));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDTO> getMostrarBlogId(@PathVariable Integer id){
        return ResponseEntity.ok().body(blogService.mostrarBlogId(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDTO>> getMostrarBlogs(){
        return ResponseEntity.ok().body(blogService.mostrarBlogs());
    }

}
