package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();
    Product findById(int id);
}
