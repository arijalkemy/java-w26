package com.bootcamp.products.mapper;

import com.bootcamp.products.dto.ProductDTO;
import com.bootcamp.products.model.Product;
import org.modelmapper.ModelMapper;

import java.util.List;

public class ProductMapper {

    public static ProductDTO productToProductDTO(Product product) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(product, ProductDTO.class);
    }

    public static Product productDTOToProduct(ProductDTO productDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(productDTO, Product.class);
    }

    public static List<ProductDTO> productsListToProductsDTOList(List<Product> products) {
        return products.stream()
                .map(ProductMapper::productToProductDTO)
                .toList();
    }

}
