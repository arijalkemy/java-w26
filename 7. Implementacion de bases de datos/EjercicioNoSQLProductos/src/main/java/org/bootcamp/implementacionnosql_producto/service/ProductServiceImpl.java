package org.bootcamp.implementacionnosql_producto.service;

import org.bootcamp.implementacionnosql_producto.dto.ProductDTO;
import org.bootcamp.implementacionnosql_producto.dto.ResponseProductDTO;
import org.bootcamp.implementacionnosql_producto.model.Product;
import org.bootcamp.implementacionnosql_producto.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ProductRepository productRepository;

    private final ModelMapper modelMapper = new ModelMapper();

//    public ProductServiceImpl() {
//    }

    @Override
    public ResponseProductDTO createProduct(ProductDTO product) {
        Product productEntity = modelMapper.map(product, Product.class);
        productEntity = productRepository.save(productEntity);

        return modelMapper.map(productEntity, ResponseProductDTO.class);
    }

    @Override
    public ResponseProductDTO updateProduct(String id, ProductDTO product) {
        Product productEntity = modelMapper.map(product, Product.class);
        productEntity.setId(id);
        productEntity = productRepository.save(productEntity);

        return modelMapper.map(productEntity, ResponseProductDTO.class);
    }
}
