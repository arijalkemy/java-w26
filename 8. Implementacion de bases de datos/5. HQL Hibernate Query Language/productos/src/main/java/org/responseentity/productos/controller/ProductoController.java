package org.responseentity.productos.controller;

import org.responseentity.productos.dto.ProductoDTO;
import org.responseentity.productos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<?> listAllProductos(){
        return new ResponseEntity<>(productoService.listAllProductos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id){
        return new ResponseEntity<>(productoService.getProductoById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductoDTO productoDTO){
        return new ResponseEntity<>(productoService.saveProducto(productoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody ProductoDTO productoDTO){
        return new ResponseEntity<>(productoService.updateProducto(id, productoDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id){
        productoService.deleteProducto(id);
        return new ResponseEntity<>("producto eliminado", HttpStatus.OK);
    }
}
