package com.bootcamp.products.service.impl;

import java.util.List;


import com.bootcamp.products.dto.ProductDTO;
import com.bootcamp.products.dto.ResponseDTO;
import com.bootcamp.products.exception.NotFoundException;
import com.bootcamp.products.mapper.ProductMapper;
import com.bootcamp.products.model.Product;
import com.bootcamp.products.repository.IProductRepository;
import com.bootcamp.products.service.IProductService;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository;
    private final String NAME_ENTITY = "product";

    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getAlls() {
        return ProductMapper.productsListToProductsDTOList(
                productRepository.findAll());
    }

    @Override
    public ProductDTO getById(String id) {
        return ProductMapper.productToProductDTO(
                productRepository.findById(id).orElseThrow(() -> new NotFoundException(NAME_ENTITY)));
    }

    @Override
    public ResponseDTO create(ProductDTO productDTO) {
        Product product = productRepository.
                save(ProductMapper.productDTOToProduct(productDTO));
        return new ResponseDTO("Product created successfully with id: " + product.getId() + " success.");
    }

    @Override
    public ResponseDTO update(String id, ProductDTO productDTO) {
        validate(productDTO.getId());
        Product product = productRepository.save(ProductMapper.productDTOToProduct(productDTO));
        return new ResponseDTO("Product updated successfully with id: " + product.getId() + " success.");
    }

    @Override
    public void delete(String id) {
        validate(id);
        productRepository.deleteById(id);
    }

    private void validate(String id) {
        if (!productRepository.existsById(id))
            throw new NotFoundException(NAME_ENTITY);

    }

}
