package com.example.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.store.Product;

public class ProductCRUD implements ICrud<Product> {

    private List<Product> productRepository;

    public ProductCRUD() {
        productRepository = new ArrayList<>();
    }

    @Override
    public void save(Product product) {
        try {
            productRepository.add(product);
        } catch (Exception e) {
            System.out.println("Error al agregar un producto - Error: " + e.getMessage());
        }
    }

    @Override
    public void show(Product product) {
        System.out.println(product.toString());
    }

    @Override
    public Optional<Product> get(String id) {
        for (Product product : productRepository) {
            if (product.getProductCode().equals(id)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    @Override
    public void delete(String id) {
        for (Product product : productRepository) {
            if (product.getProductCode().equals(id)) {
                productRepository.remove(product);
            }
        }
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository;
    }

}
