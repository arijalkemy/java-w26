package com.mercadolibre.Productos_NOSQL.service.impl;

import com.mercadolibre.Productos_NOSQL.dto.ProductRequestDto;
import com.mercadolibre.Productos_NOSQL.dto.ProductResponseDto;
import com.mercadolibre.Productos_NOSQL.exception.NotFoundException;
import com.mercadolibre.Productos_NOSQL.model.Product;
import com.mercadolibre.Productos_NOSQL.repository.IProductRepository;
import com.mercadolibre.Productos_NOSQL.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    ModelMapper mapper = new ModelMapper();

    @Autowired
    IProductRepository repository;

    @Override
    public ProductResponseDto saveProduct(ProductRequestDto product) {
        return mapper.map(
                repository.save(mapper.map(product, Product.class)),
                ProductResponseDto.class
        );
    }

    @Override
    public ProductResponseDto updateProduct(String id, ProductRequestDto product) {
        Product originProduct = repository.findById(id).orElseThrow(
                () -> new NotFoundException("No se encuentra el producto, valide la información.")
        );
        originProduct.setName(product.getName());
        originProduct.setType(product.getType());
        originProduct.setPrice_sale(product.getPrice_sale());
        originProduct.setPrice_cost(product.getPrice_cost());
        originProduct.setCant_disp(product.getCant_disp());
        return mapper.map(repository.save(originProduct),ProductResponseDto.class);
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {

        return repository.findAll().stream().map(
                product -> mapper.map(product,ProductResponseDto.class)
        ).toList();
    }
}
