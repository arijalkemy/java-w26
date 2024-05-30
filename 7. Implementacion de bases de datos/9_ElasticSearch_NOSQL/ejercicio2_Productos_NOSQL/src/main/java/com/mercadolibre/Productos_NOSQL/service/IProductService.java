package com.mercadolibre.Productos_NOSQL.service;

import com.mercadolibre.Productos_NOSQL.dto.ProductRequestDto;
import com.mercadolibre.Productos_NOSQL.dto.ProductResponseDto;

import java.util.List;

public interface IProductService {
    public ProductResponseDto saveProduct(ProductRequestDto product);
    public ProductResponseDto updateProduct(String id, ProductRequestDto product);
    public List<ProductResponseDto> getAllProducts();
}
