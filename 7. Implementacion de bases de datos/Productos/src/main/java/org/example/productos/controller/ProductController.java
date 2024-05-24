package org.example.productos.controller;

import org.example.productos.model.DTO.ProductRequestDTO;
import org.example.productos.model.DTO.ProductResponseDTO;
import org.example.productos.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productos")
public class ProductController {

    @Autowired
    IProductService productService;

    @PostMapping("/new")
    ResponseEntity<ProductResponseDTO> postEmpleado(@RequestBody ProductRequestDTO product){
        return new ResponseEntity<>(productService.createNew(product), HttpStatus.CREATED);
    }

    @GetMapping()
    ResponseEntity<List<ProductResponseDTO>> getAll(){
        return new ResponseEntity<>(productService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<ProductResponseDTO> getById(@PathVariable String id){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<ProductResponseDTO> updateById(@PathVariable String id, @RequestBody ProductRequestDTO product){
        return new ResponseEntity<>(productService.updateProductById(id,product),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteById( @PathVariable String id){
        return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
    }

    @GetMapping(params = "type")
    ResponseEntity<List<ProductResponseDTO>> getAllByType(@RequestParam String type){
        return new ResponseEntity<>(productService.findProductByType(type), HttpStatus.OK);
    }

}
