package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.impl;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.Product;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.IProductRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("prod")
public class ProductRepositoryImpl implements IProductRepository {

    private List<Product> listProduct;

    public ProductRepositoryImpl() {
        this.listProduct = new ArrayList<>();
        listProduct.add(new Product(1, "HyperX Cloud II", "Headset", "HyperX", "Red", "Excellent noise canceling"));
        listProduct.add(new Product(2, "Logitech MX Master 3", "Mouse", "Logitech", "Black", "Ergonomic design"));
        listProduct.add(new Product(3, "Dell XPS 15", "Laptop", "Dell", "Silver", "High performance"));
        listProduct.add(new Product(4, "Apple MacBook Pro", "Laptop", "Apple", "Grey", "M1 chip 2020 model"));
        listProduct.add(new Product(5, "Samsung Galaxy S22", "Smartphone", "Samsung", "Phantom Black", "Latest model"));
        listProduct.add(new Product(6, "iPhone 13 Pro", "Smartphone", "Apple", "Sierra Blue", "5G support"));
        listProduct.add(new Product(7, "Canon EOS R5", "Camera", "Canon", "Black", "Professional grade mirrorless"));
        listProduct.add(new Product(8, "Nikon Z6", "Camera", "Nikon", "Black", "Great for videography"));
        listProduct.add(new Product(9, "Sony WH 1000XM4", "Headset", "Sony", "Black", "Industry leading noise cancellation"));
        listProduct.add(new Product(10, "Google Pixel 6", "Smartphone", "Google", "Sorta Seafoam", "Android 12 pre installed"));
        listProduct.add(new Product(11, "Xbox Series X", "Console", "Microsoft", "Black", "8K HDR gaming"));
        listProduct.add(new Product(12, "PlayStation 5", "Console", "Sony", "White", "Supports ray tracing"));
        listProduct.add(new Product(13, "JBL Flip 5", "Speaker", "JBL", "Blue", "Waterproof, portable"));
        listProduct.add(new Product(14, "Bose QuietComfort 35", "Headset", "Bose", "Silver", "Comfortable over ear"));
        listProduct.add(new Product(15, "OnePlus 9", "Smartphone", "OnePlus", "Winter Mist", "120 Hz Fluid Display"));
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
