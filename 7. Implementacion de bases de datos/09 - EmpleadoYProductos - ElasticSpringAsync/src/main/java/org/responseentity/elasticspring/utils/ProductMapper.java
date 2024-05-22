package org.responseentity.elasticspring.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.responseentity.elasticspring.domain.Product;
import org.responseentity.elasticspring.dto.request.ProductRequestDto;
import org.responseentity.elasticspring.dto.response.ProductResponseDto;

public class ProductMapper {
    public static Product mapToProduct(ProductRequestDto productRequestDto){
        return new ObjectMapper().convertValue(productRequestDto, Product.class);
    }

    public static ProductResponseDto mapToResponse(Product product){
        return new ObjectMapper().convertValue(product, ProductResponseDto.class);
    }
}
