package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.EntradaBlogDto;
import com.bootcamp.blog.service.interfaces.IBlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {


    private final IBlogService blogService;

    public BlogController(IBlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDto>> getAll(){

        List<EntradaBlogDto> listEntradasBlog = blogService.getAll();

        return ResponseEntity.ok(listEntradasBlog);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDto> getById(@PathVariable int id){

        EntradaBlogDto entradaBlogDto = blogService.getById(id);

        return ResponseEntity.ok(entradaBlogDto);

    }

    @PostMapping("/blog")
    public ResponseEntity<String> post(@RequestBody EntradaBlogDto entradaBlogDto){

        String respuesta = blogService.create(entradaBlogDto);

        return ResponseEntity.ok(respuesta);
    }

}
