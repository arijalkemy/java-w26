package org.responseentity.elasticspring.service;

import org.responseentity.elasticspring.dto.request.ProductRequestDto;
import org.responseentity.elasticspring.dto.response.ProductResponseDto;

public interface IProductService {
    ProductResponseDto addProduct(ProductRequestDto productRequestDto);
    ProductResponseDto editProduct(String id, ProductRequestDto productRequestDto);
}
