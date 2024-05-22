package com.w26.elasticsearch.elasticsearch.service.interfaces;

import java.util.List;

import com.w26.elasticsearch.elasticsearch.dto.ProductDTO;
import com.w26.elasticsearch.elasticsearch.entity.Product;

public interface IProductService {

    public List<Product> getAllProducts();

    public String  createProduct(ProductDTO product);
    public Boolean updateProduct(String id, ProductDTO product);
}
