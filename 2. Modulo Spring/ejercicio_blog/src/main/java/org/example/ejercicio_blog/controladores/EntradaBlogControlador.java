package org.example.ejercicio_blog.controladores;

import org.example.ejercicio_blog.dtos.BlogDTO;
import org.example.ejercicio_blog.servicios.IEntradaBlogServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController

public class EntradaBlogControlador {

    @Autowired
    IEntradaBlogServicio entradaBlogServicio;

    @PostMapping("/nuevo")
    public BlogDTO crearEntradaBlog(@RequestBody BlogDTO blogDTO) {
       return entradaBlogServicio.crearEntrada(blogDTO);
    }
    @GetMapping("/blog/{id}")
    public BlogDTO obtenerEntradaBlog(@PathVariable Long id) {
        return entradaBlogServicio.obtenerPorID(id);
    }
    @GetMapping("/blogs")
    public List<BlogDTO> obtenerEntradaBlogs() {
        return entradaBlogServicio.obtenerTodos();
    }
}
