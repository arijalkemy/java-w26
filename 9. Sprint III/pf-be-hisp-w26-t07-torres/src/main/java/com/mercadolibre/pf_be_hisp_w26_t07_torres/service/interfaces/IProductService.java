package com.mercadolibre.pf_be_hisp_w26_t07_torres.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.product.*;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.warehouse.StockQuantityResponseDto;

import java.util.List;

public interface IProductService {
    List<ProductResponseDTO> getProducts(String category);

    StockQuantityResponseDto findStockQuantityForEachWarehouse(Long idProduct);

    LocationForProductDTO checkLocationForProduct(Long idProduct, String order);

    ProductCreateResponseDto createProductSeller(Long idSeller, ListProductRequestDto productRequestDto);

    ProductCreateResponseDto updateProductSeller(Long idSeller, Long productSellerId, ProductRequestDto productRequestDto);
}
