package com.mercadolibre.pf_be_hisp_w26_t10_hoyos.service;


import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.entity.Product;

import java.util.List;

public interface IProductService {
    CheckInventoryResponseDto getProductWh(Integer idProduct);
    Product findById(Integer id);
    public List<ProductsGeneralDto> getProducts();
    public List<ProductsGeneralDto> findProductsByCategory(String category);
    SellerProductResponseDto createNewSellerProduct(Long idSeller, SellerProductRequestDto sellerOrder);
    SellerProductResponseDto updateSellerProduct(Long idSeller, Integer productId ,ProductDto product);
    List<ProductDto> getSellerProducts(Long idSeller);
    SellerProductResponseDto deleteSellerProduct(Integer idProduct);
}
