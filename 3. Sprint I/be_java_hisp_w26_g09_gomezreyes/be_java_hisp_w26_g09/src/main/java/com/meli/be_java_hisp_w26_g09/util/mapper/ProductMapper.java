package com.meli.be_java_hisp_w26_g09.util.mapper;

import com.meli.be_java_hisp_w26_g09.dto.ProductDTO;
import com.meli.be_java_hisp_w26_g09.entity.Product;

public class ProductMapper {
    public Product productDTOtoProduct(ProductDTO product) {
        return new Product(product.getProductId(),
                product.getProductName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes());
    }
}
