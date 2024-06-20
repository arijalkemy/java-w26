package com.mercadolibre.pf_be_hisp_w26_t10_garcia.service;

import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.Product;

import java.util.List;

public interface IProductService {
    CheckInventoryResponseDto getProductWh(Integer idProduct);
    Product findById(Integer id);
    ProductsOperationResponseDTO saveProducts(ProductsRequestDTO products, Long sellerId);
    ProductsOperationResponseDTO update(Integer idProduct, Long idSeller, ProductSellerRequestDTO product);
    List<ProductSellerResponseDTO> findProductBySellerId(Long id);
    ProductsOperationResponseDTO updateProducts(ProductUpdateRequestDTO products, Long idSeller);
}
