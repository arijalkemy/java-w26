package org.ejercicio.blog.controller;

import org.ejercicio.blog.dto.EntradaBlogDTO;
import org.ejercicio.blog.dto.EntradaBlogResponseDTO;
import org.ejercicio.blog.entity.EntradaBlog;
import org.ejercicio.blog.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blog")
public class EntradaBlogController {

    @Autowired
    IEntradaBlogService entradaBlogService;

    @PostMapping
    public ResponseEntity<EntradaBlogResponseDTO> crearBlog(@RequestBody EntradaBlogDTO entradaBlog) {
        return new ResponseEntity<>(entradaBlogService.agregarBlog(entradaBlog), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<EntradaBlogResponseDTO> obtenerBlog(@PathVariable int id) {
        return new ResponseEntity<>(entradaBlogService.buscarPorId(id),HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<EntradaBlogResponseDTO>> obtenerBlogS() {
        return new ResponseEntity<>(entradaBlogService.buscarTodos(),HttpStatus.OK);
    }
}
