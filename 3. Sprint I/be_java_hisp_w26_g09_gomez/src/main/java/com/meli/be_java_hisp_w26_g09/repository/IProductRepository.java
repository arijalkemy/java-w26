package com.meli.be_java_hisp_w26_g09.repository;

import com.meli.be_java_hisp_w26_g09.entity.Product;

import java.util.List;


public interface IProductRepository {
    Boolean isCreated(Product product);

    void createProduct(Product product);
}
