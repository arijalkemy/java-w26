package org.example.producto.controller;

import org.example.producto.dto.ProductoDto;
import org.example.producto.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    IProductService productService;

    @PostMapping
    public ResponseEntity<String> postEmpleado(@RequestBody ProductoDto productoDto) {
        productService.saveProducto(productoDto);
        return ResponseEntity.status(HttpStatus.OK).body("productoDto creado con exito");
    }

    // SE PUEDE EDITAR AL EMPLEDAO DESDE EL ENDPOINT DE POST, IGUALMENTE SE IMPLEMENTA PUT
    @PutMapping
    public ResponseEntity<String> updateEmpleado(@RequestBody ProductoDto productoDto) {
        productService.updateProducto(productoDto);
        return ResponseEntity.status(HttpStatus.OK).body("producto actualizado con exito");
    }

    @GetMapping
    public ResponseEntity<List<ProductoDto>> getAllEmpleados() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProductos());
    }

}
