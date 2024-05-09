package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.repository;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();
    Product findById(int id);
}
