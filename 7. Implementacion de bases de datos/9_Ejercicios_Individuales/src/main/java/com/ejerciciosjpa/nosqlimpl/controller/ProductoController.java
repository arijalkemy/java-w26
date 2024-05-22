package com.ejerciciosjpa.nosqlimpl.controller;

import com.ejerciciosjpa.nosqlimpl.dto.ProductoRequestDto;
import com.ejerciciosjpa.nosqlimpl.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
public class ProductoController {
    @Autowired
    IProductoService productoService;

    @PostMapping("/producto")
    public ResponseEntity<?> createProducto(@RequestBody ProductoRequestDto request){
        return new ResponseEntity<>(productoService.save(request), HttpStatus.CREATED);
    }
    @PutMapping("/producto/{id}")
    public ResponseEntity<?> updateProducto(@PathVariable String id,@RequestBody ProductoRequestDto request){
        return new ResponseEntity<>(productoService.modify(id,request),HttpStatus.OK);
    }
    @GetMapping("/producto")
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<>(productoService.getAllProducto(),HttpStatus.OK);
    }
}
