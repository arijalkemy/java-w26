package com.example.elastic.service;

import com.example.elastic.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Product save (Product prod);

    public List<Product> findAll();

    public Optional<Product> findById(int id);

    public String deleteProduct (int id);

    public String editProduct (Product product);
}
