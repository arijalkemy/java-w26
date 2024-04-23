package com.example.libros.controller;


import com.example.libros.dto.BlogDTO;
import com.example.libros.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    IBlogService iBlogService;

    @GetMapping("/blogs")
    public List<BlogDTO> obtenerBlogs(){
        return iBlogService.obtenerBlogs();
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> obtenerBlog (@PathVariable Integer id){
        if(id != null) {
            BlogDTO blogDTO = iBlogService.obtenerBlog(id);
            if (blogDTO != null) {
                return ResponseEntity.ok(blogDTO);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            throw new IllegalArgumentException("El id no puede ser nullo");
        }
    }


    @PostMapping("/blog")
    public void crearBlog(@RequestBody BlogDTO blogDTO){
        iBlogService.crearBlog(blogDTO);

    }


}
