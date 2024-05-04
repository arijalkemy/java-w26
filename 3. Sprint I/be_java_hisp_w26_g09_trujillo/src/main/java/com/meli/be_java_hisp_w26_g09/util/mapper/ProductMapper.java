package com.meli.be_java_hisp_w26_g09.util.mapper;

import com.meli.be_java_hisp_w26_g09.dto.ProductDTO;
import com.meli.be_java_hisp_w26_g09.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {

    public List<ProductDTO> productToProductDTO(List<Product> products) {
        if (products == null)
            return new ArrayList<>();

        return products.stream().map(product -> new ProductDTO(product.getProductId(),product.getProductName(),product.getType(),product.getBrand(),product.getColor(),product.getNotes())).toList();
    }
}