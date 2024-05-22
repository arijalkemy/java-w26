package com.implementaciondb.ejercicio8_productos_elasticsearch.service;


import com.implementaciondb.ejercicio8_productos_elasticsearch.exception.NotFoundException;
import com.implementaciondb.ejercicio8_productos_elasticsearch.mapper.ProductMapper;
import com.implementaciondb.ejercicio8_productos_elasticsearch.model.domain.Product;
import com.implementaciondb.ejercicio8_productos_elasticsearch.model.dto.ProductRequestDto;
import com.implementaciondb.ejercicio8_productos_elasticsearch.model.dto.ProductResponseDto;
import com.implementaciondb.ejercicio8_productos_elasticsearch.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public ProductResponseDto saveProduct(ProductRequestDto product) {
        Product savedEmployed = productRepository.save(ProductMapper.mapToProduct(product));
        return ProductMapper.mapToProductResponseDto(savedEmployed);
    }

    @Override
    public List<ProductResponseDto> findAllProducts() {
        Iterable<Product> iterable = productRepository.findAll();
        List<Product> products = StreamSupport.stream(iterable.spliterator(), false).toList();
        return products.stream().map(ProductMapper::mapToProductResponseDto).toList();
    }

    @Override
    public ProductResponseDto findProductById(String id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "No existe un documento con el id: " + id)
        );
        return ProductMapper.mapToProductResponseDto(product);
    }

    @Override
    public ProductResponseDto updateProduct(String id, ProductRequestDto product) {
        findProductById(id);
        Product productMapped = ProductMapper.mapToProduct(product);
        productMapped.setId(id);
        Product updatedEmployed = productRepository.save(productMapped);
        return ProductMapper.mapToProductResponseDto(updatedEmployed);
    }

}
