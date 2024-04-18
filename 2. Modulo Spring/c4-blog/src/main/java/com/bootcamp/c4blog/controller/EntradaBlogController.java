package com.bootcamp.c4blog.controller;

import com.bootcamp.c4blog.dto.BlogRequestDTO;
import com.bootcamp.c4blog.dto.BlogResponseDTO;
import com.bootcamp.c4blog.dto.EntradaBlogResponseDTO;
import com.bootcamp.c4blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntradaBlogController {

    @Autowired
    private IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<BlogResponseDTO> agregarEntrada(@RequestBody BlogRequestDTO blogDTO){
        Integer idCreado = blogService.crearEntrada(blogDTO);
        BlogResponseDTO response = new BlogResponseDTO(idCreado);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogResponseDTO>> obtenerEntradas(){
        return ResponseEntity.ok(blogService.obtenerEntradas());
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogResponseDTO> obtenerEntrada(@PathVariable Integer id){
        return ResponseEntity.ok(blogService.obtenerEntrada(id));
    }

}
