package org.example.elastic.service;

import org.example.elastic.dto.product.ProductResponseDto;

public interface IProductService {
    ProductResponseDto getProductById(String id);
}
