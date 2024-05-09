package com.meli.be_java_hisp_w26_g09.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w26_g09.entity.Product;
import com.meli.be_java_hisp_w26_g09.repository.IProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    List<Product> listOfProduct = new ArrayList<>();

    public ProductRepositoryImpl() throws IOException {
        loadDataBase();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> products;

        file = ResourceUtils.getFile("classpath:products_generated.json");
        products = objectMapper.readValue(file, new TypeReference<>() {
        });
        listOfProduct = products;
    }

    @Override
    public boolean isCreated(Product product) {
        return listOfProduct.stream().anyMatch(p -> p.equals(product));
    }

    @Override
    public void createProduct(Product product) {
        listOfProduct.add(product);
    }
}
