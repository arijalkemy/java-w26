package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.impl;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.Product;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.IProductRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("test")
public class TestProductRepositoryImpl implements IProductRepository {
    private List<Product> listProduct;

    public TestProductRepositoryImpl() {
        this.listProduct = new ArrayList<>();
        listProduct.add(new Product(1, "HyperX Cloud II", "Headset", "HyperX", "Red", "Excellent noise canceling"));
        listProduct.add(new Product(2, "Logitech MX Master 3", "Mouse", "Logitech", "Black", "Ergonomic design"));
        listProduct.add(new Product(3, "Dell XPS 15", "Laptop", "Dell", "Silver", "High performance"));
        listProduct.add(new Product(4, "Apple MacBook Pro", "Laptop", "Apple", "Grey", "M1 chip 2020 model"));
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(listProduct);
    }

    @Override
    public List<Product> getAll() {
        return listProduct;
    }

    @Override
    public Product findById(int id) {
        return listProduct.stream().filter(user -> user.getProductId() == id).findFirst().orElse(null);
    }
}
