package org.example.blog.controller;

import org.example.blog.dto.EntradaBlogDto;
import org.example.blog.dto.MensajeRespuestaDto;
import org.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    IBlogService blogService;


    @GetMapping
    public ResponseEntity<?> buscarTodasLasEntradasBlog() {
        return ResponseEntity.ok(blogService.buscarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarEntradaBlogPorId(@PathVariable int id) {

        return ResponseEntity.ok(blogService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<?> crearEntradaBlog(@RequestBody EntradaBlogDto entradaBlogDto) {

        blogService.crearEntradaBlog(entradaBlogDto);

        return ResponseEntity.ok(new MensajeRespuestaDto("La nueva Entrada de Blog fue creada con éxito"));
    }
}
