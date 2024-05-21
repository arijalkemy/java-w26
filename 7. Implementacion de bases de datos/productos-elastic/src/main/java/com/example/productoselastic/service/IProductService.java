package com.example.productoselastic.service;

import java.util.List;

import com.example.productoselastic.dto.ProductRequestDto;
import com.example.productoselastic.dto.ProductResponseDto;


public interface IProductService {
    ProductResponseDto create(ProductRequestDto productRequestDto);
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto update(String id, ProductRequestDto productRequestDto);
}
