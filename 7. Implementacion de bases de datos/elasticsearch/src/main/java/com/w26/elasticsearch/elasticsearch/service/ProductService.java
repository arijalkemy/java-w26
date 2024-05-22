package com.w26.elasticsearch.elasticsearch.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.w26.elasticsearch.elasticsearch.dto.ProductDTO;
import com.w26.elasticsearch.elasticsearch.entity.Product;
import com.w26.elasticsearch.elasticsearch.repository.ProductRepository;
import com.w26.elasticsearch.elasticsearch.service.interfaces.IProductService;
@Service
public class ProductService implements IProductService {
    
    @Autowired
    ProductRepository productRepository;

    private final ObjectMapper objectMapper;
    
    public ProductService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @Override
    public List<Product> getAllProducts() 
    {
        Iterable<Product> productsIterable = productRepository.findAll();
        List<Product> products = StreamSupport.stream(productsIterable.spliterator(), false).toList(); 
        return products;
    }

    @Override
    public String createProduct(ProductDTO product) {
        Product productToSave = objectMapper.convertValue(product, Product.class);
        Product productSaved = productRepository.save(productToSave);
        return productSaved.getId().toString();

    }

    @Override
    public Boolean updateProduct(String id, ProductDTO product) {
        Optional<Product> optional = productRepository.findById(id);
        
        if (optional.isEmpty()) {
            return false;
        }
        Product baseData = optional.get();
        Product dataToUpdate = this.objectMapper.convertValue(product, Product.class);
        dataToUpdate.setId(baseData.getId());
        System.out.println(dataToUpdate);
        productRepository.save(dataToUpdate);
        
        return true;
    }
}
