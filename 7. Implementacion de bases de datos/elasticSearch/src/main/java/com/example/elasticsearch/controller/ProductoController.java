package com.example.elasticsearch.controller;

import com.example.elasticsearch.entity.Producto;
import com.example.elasticsearch.service.IProductoService;
import com.example.elasticsearch.service.ProductoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final IProductoService productoService;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(productoService.getProductos());
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getProductByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(productoService.getProductosByName(name));
    }

    @PostMapping
    public ResponseEntity<?> addProducto(@RequestBody Producto producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.insertProducto(producto));
    }
}
