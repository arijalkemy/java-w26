package com.example.productoselastic.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productoselastic.dto.ProductRequestDto;
import com.example.productoselastic.dto.ProductResponseDto;
import com.example.productoselastic.models.Product;
import com.example.productoselastic.repository.IProductRepository;


@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository productRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public ProductResponseDto create(ProductRequestDto productRequestDto) {
        Product product = modelMapper.map(productRequestDto, Product.class);
        productRepository.save(product);
        return modelMapper.map(product, ProductResponseDto.class);
    }

    @Override
    public List<ProductResponseDto> getAllProducts()
    {
        return productRepository.findAll()
            .stream()
            .map(product -> modelMapper.map(product, ProductResponseDto.class))
            .toList();
    }

    @Override
    public ProductResponseDto update(String id, ProductRequestDto productRequestDto)
    {
        productRepository.findById(id).orElseThrow( () -> new RuntimeException("Product not found"));


        Product productToSave = modelMapper.map(productRequestDto, Product.class);
        productToSave.setId(id);

        productRepository.save(productToSave);
        return modelMapper.map(productToSave, ProductResponseDto.class);
    }

}
