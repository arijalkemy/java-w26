package com.ejercicio.productos.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.productos.dtos.ProductoDTO;
import com.ejercicio.productos.services.IProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/products")
public class ProductoController {

    @Autowired
    IProductoService productoService;

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEmpleado(@PathVariable String id, @RequestBody ProductoDTO productoDto) {
        return ResponseEntity.status(200).body(productoService.actualizar(id, productoDto));
    }

    @GetMapping("")
    public ResponseEntity<?> obtenerEmpleados() {
        return ResponseEntity.status(200).body(productoService.obtenerProductos());
    }

    @PostMapping("")
    public ResponseEntity<?> crearEmpleado(@RequestBody ProductoDTO productoDto) {
        return ResponseEntity.status(201).body(productoService.crearProducto(productoDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEmpleadoPorId(@PathVariable("id") String id) {
        return ResponseEntity.status(201).body(productoService.obtenerProductoPorId(id));
    }
    
}
