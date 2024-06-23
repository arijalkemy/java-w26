package org.example.productoelastic.controller;


import org.example.productoelastic.dto.ProductoDTO;
import org.example.productoelastic.servicio.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @PostMapping("/")
    public ResponseEntity<?> saveProducto(@RequestBody ProductoDTO producto) {
        return new ResponseEntity<>(productoService.saveProducto(producto), HttpStatus.OK);
    }
}
