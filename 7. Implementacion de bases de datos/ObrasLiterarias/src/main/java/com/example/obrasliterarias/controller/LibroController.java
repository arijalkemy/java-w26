package com.example.obrasliterarias.controller;

import com.example.obrasliterarias.entity.Libro;
import com.example.obrasliterarias.services.ILibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/libro")
@RequiredArgsConstructor
public class LibroController {

    private final ILibroService libroService;

    @GetMapping
    public ResponseEntity<?> obtenerTodoLosLibros(){
        return ResponseEntity.status(HttpStatus.OK).body(libroService.obtenerTodoLosLibros());
    }

    @GetMapping("/{autor}")
    public ResponseEntity<?> obtenerLibrosPorAutor(@PathVariable String autor){
        return ResponseEntity.status(HttpStatus.OK).body(libroService.buscarPorAutor(autor));
    }

    @GetMapping("/top")
    public ResponseEntity<?> obtenerLibrosPorAutor(){
        return ResponseEntity.status(HttpStatus.OK).body(libroService.findTop5ByOrderByCantidadDePaginasDesc());
    }

    @GetMapping("/busqueda/{nombre}")
    public ResponseEntity<?> obtenerLibrosPorNombre(@PathVariable String nombre){
        return ResponseEntity.status(HttpStatus.OK).body(libroService.findByNombreContaining(nombre));
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<?> obtenerLibrosPorEditorial(@PathVariable String editorial){
        return ResponseEntity.status(HttpStatus.OK).body(libroService.findByEditorial(editorial));
    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<?> obtenerLibrosPorFecha(@PathVariable LocalDate fecha){
        return ResponseEntity.status(HttpStatus.OK).body(libroService.findByFechaPublicacionBefore(fecha));
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Libro libr)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(libroService.guardar(libr));
    }



}
