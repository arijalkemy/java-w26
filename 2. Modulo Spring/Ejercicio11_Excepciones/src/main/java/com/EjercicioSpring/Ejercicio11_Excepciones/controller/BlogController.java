package com.EjercicioSpring.Ejercicio11_Excepciones.controller;

import com.EjercicioSpring.Ejercicio11_Excepciones.dto.BlogDTO;
import com.EjercicioSpring.Ejercicio11_Excepciones.exception.BlogExistenteException;
import com.EjercicioSpring.Ejercicio11_Excepciones.exception.BlogInexistenteException;
import com.EjercicioSpring.Ejercicio11_Excepciones.exception.SoloSeAceptanNumerosException;
import com.EjercicioSpring.Ejercicio11_Excepciones.exception.TablaVaciaException;
import com.EjercicioSpring.Ejercicio11_Excepciones.service.interfaces.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<String> crearBlog(@RequestBody BlogDTO blogDTO) {
        if (blogService.crearLibro(blogDTO)) {
            return ResponseEntity.status(HttpStatus.OK).body("Operación éxitosa");
        }
        throw new BlogExistenteException("Ya existe un blog con el ID: " + blogDTO.getId());
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> obtenerBlogPorId(@PathVariable String id) {
        if (id.matches("[0-9]+")) {
            BlogDTO blogDTO = blogService.obtenerLibroPorId(Long.parseLong(id));
            if (blogDTO == null) {
                throw new BlogInexistenteException("No existe registrado un blog con el ID: " + id);
            }
            return ResponseEntity.status(HttpStatus.OK).body(blogDTO);
        } else {
            throw new SoloSeAceptanNumerosException("El valor recibido debe ser de tipo numérico");
        }
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> obtenerBlogs() {
        List<BlogDTO> blogDTOS = blogService.obtenerBlogs();
        if (blogDTOS.isEmpty()) {
            throw new TablaVaciaException("No existen blogs registrados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(blogDTOS);
    }
}
