package com.productosejindelastic.controllers;


import com.productosejindelastic.DTOs.ProductoRequestDTO;
import com.productosejindelastic.services.IProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<?> getProductos() {
        return new ResponseEntity<>(
                this.productoService.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable String id) {
        return new ResponseEntity<>(
                this.productoService.findById(id),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<?> createProducto(@RequestBody ProductoRequestDTO productoRequestDTO) {
        return new ResponseEntity<>(
                this.productoService.crear(productoRequestDTO),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProducto(
            @PathVariable String id,
            @RequestBody ProductoRequestDTO productoRequestDTO
    ) {
        return new ResponseEntity<>(
                this.productoService.update(id,productoRequestDTO),
                HttpStatus.CREATED
        );
    }

}
