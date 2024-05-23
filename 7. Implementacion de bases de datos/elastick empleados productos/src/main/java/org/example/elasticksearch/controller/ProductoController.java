package org.example.elasticksearch.controller;

import org.example.elasticksearch.domain.Producto;
import org.example.elasticksearch.service.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    IProductosService productoService;

    @PostMapping("/new")
    ResponseEntity<?> createProduct(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.createProducto(producto));
    }
}
