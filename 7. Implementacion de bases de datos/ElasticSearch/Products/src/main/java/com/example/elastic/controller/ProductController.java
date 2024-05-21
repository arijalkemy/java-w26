package com.example.elastic.controller;

import com.example.elastic.domain.Product;
import com.example.elastic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/new")
    public Product save (@RequestBody Product prod) {
        return productService.save(prod);

    }

    @GetMapping("/product")
    public List<Product> findAll () {

        return productService.findAll();
    }

    @GetMapping ("/product/{id}")
    //va optional porque puede que devuelva como puede que no
    public Optional<Product> findById(@PathVariable int id) {

        return productService.findById(id);
    }

    @DeleteMapping ("product/delete/{id}")
    public String deleteProduct (@PathVariable int id) {

        return productService.deleteProduct(id);
    }

    @PutMapping ("product/edit")
    public String editProduct (@RequestBody Product prod) {

        return productService.editProduct(prod);
    }

}
