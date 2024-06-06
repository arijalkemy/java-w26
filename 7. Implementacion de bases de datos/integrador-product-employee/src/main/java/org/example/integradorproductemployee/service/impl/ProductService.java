package org.example.integradorproductemployee.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import org.example.integradorproductemployee.entity.Product;
import org.example.integradorproductemployee.entity.dto.ProductDTO;
import org.example.integradorproductemployee.entity.dto.ProductUtilDTO;
import org.example.integradorproductemployee.repository.IProductRepository;
import org.example.integradorproductemployee.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductRepository productRepository;
    private final ObjectMapper objectMapper;

    private ProductUtilDTO mapToUtilDTO(Product product){
        return objectMapper.convertValue(product, ProductUtilDTO.class);
    }

    private ProductDTO mapToDTO(Product product){
        return objectMapper.convertValue(product, ProductDTO.class);
    }

    private Product mapToEntity(ProductDTO productDTO){
        return objectMapper.convertValue(productDTO, Product.class);
    }

    private Product mapToEntity(ProductUtilDTO productUtilDTO){
        return objectMapper.convertValue(productUtilDTO, Product.class);
    }

    @Override
    public List<ProductUtilDTO> getAllProducts() {
        Iterable<Product> productIterable = productRepository.findAll();
        List<Product> products = StreamSupport.stream(productIterable.spliterator(), false).toList();
        return products.stream().map(this::mapToUtilDTO).toList();
    }

    @Override
    public ProductDTO getProductById(String id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(this::mapToDTO).orElse(null);
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        productRepository.save(mapToEntity(productDTO));
    }

    @Override
    public void updateProduct(ProductUtilDTO productUtilDTO) {
        productRepository.save(mapToEntity(productUtilDTO));
    }
}
