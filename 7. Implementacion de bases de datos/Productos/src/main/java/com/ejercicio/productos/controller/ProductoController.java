package com.ejercicio.productos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.productos.dto.ProductoDTO;
import com.ejercicio.productos.service.IProductoService;

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
        return new ResponseEntity<>(productoService.actualizar(id, productoDto), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> obtenerEmpleados() {
        return new ResponseEntity<>(productoService.obtenerProductos(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> crearEmpleado(@RequestBody ProductoDTO productoDto) {
        return new ResponseEntity<>(productoService.crearProducto(productoDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEmpleadoPorId(@PathVariable("id") String id) {
        return new ResponseEntity<>(productoService.obtenerProductoPorId(id), HttpStatus.OK);
    }
    
}
