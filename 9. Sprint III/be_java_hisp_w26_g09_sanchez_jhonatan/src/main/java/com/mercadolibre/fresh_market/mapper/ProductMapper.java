package com.mercadolibre.fresh_market.mapper;

import com.mercadolibre.fresh_market.dtos.product.ProductDetailDTO;
import com.mercadolibre.fresh_market.model.Product;
import org.modelmapper.ModelMapper;

public class ProductMapper {

    private ProductMapper() {}

    public static Product productDetailDTOToProduct(ProductDetailDTO productDetailDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(productDetailDTO, Product.class);
    }

    public static ProductDetailDTO productToProductDetailDTO(Product product) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(product, ProductDetailDTO.class);
    }

}
