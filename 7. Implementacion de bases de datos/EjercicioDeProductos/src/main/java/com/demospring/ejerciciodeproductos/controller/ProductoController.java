package com.demospring.ejerciciodeproductos.controller;

import com.demospring.ejerciciodeproductos.model.Producto;
import com.demospring.ejerciciodeproductos.service.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoController {
    private final IProductoService iProductoService;

    @GetMapping
    public ResponseEntity<?> obtenerProductos(){
        return ResponseEntity.ok(iProductoService.obtenerProductos());
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarProducto(@RequestBody Producto producto){
        iProductoService.agregarProducto(producto);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }
}
