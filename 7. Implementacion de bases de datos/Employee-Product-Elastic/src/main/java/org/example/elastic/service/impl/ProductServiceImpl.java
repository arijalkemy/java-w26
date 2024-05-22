package org.example.elastic.service.impl;

import org.example.elastic.dto.product.ProductResponseDto;
import org.example.elastic.repository.IProductRepository;
import org.example.elastic.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository;

    public ProductServiceImpl(@Autowired IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDto getProductById(String id) {
        ModelMapper modelMapper = new ModelMapper();
        return productRepository
                .findById(id).map(productDto -> modelMapper.map(productDto, ProductResponseDto.class))
                .orElse(null);
    }
}
