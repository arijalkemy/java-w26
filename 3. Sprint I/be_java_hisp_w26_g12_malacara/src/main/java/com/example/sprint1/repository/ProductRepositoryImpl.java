package com.example.sprint1.repository;

import com.example.sprint1.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class ProductRepositoryImpl {

    private static List<Product> listOfProducts;

    public ProductRepositoryImpl() throws IOException {
        loadDatabase();
    }

    private void loadDatabase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> products;

        file= ResourceUtils.getFile("classpath:products.json");
        products = objectMapper.readValue(file,new TypeReference<List<Product>>(){});

        listOfProducts = products;
    }

}
