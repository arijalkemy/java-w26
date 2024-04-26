package com.group03.sprint1.repository.implementation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.group03.sprint1.entity.Product;
import com.group03.sprint1.entity.Publication;
import com.group03.sprint1.repository.IProductsRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductsRepositoryImpl implements IProductsRepository {

    List<Product> products;

    public ProductsRepositoryImpl() throws IOException {
        loadDataBase();;
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        List<Product> productList ;

        file= ResourceUtils.getFile("classpath:product.json");
        productList= objectMapper.readValue(file,new TypeReference<List<Product>>(){});

        products = productList;
    }

}
