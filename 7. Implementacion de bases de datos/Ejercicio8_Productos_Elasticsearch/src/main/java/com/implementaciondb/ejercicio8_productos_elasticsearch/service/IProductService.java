package com.implementaciondb.ejercicio8_productos_elasticsearch.service;

import com.implementaciondb.ejercicio8_productos_elasticsearch.model.dto.ProductRequestDto;
import com.implementaciondb.ejercicio8_productos_elasticsearch.model.dto.ProductResponseDto;

import java.util.List;

public interface IProductService {
    ProductResponseDto saveProduct(ProductRequestDto product);

    ProductResponseDto updateProduct(String id, ProductRequestDto product);

    List<ProductResponseDto> findAllProducts();

    ProductResponseDto findProductById(String id);
}
