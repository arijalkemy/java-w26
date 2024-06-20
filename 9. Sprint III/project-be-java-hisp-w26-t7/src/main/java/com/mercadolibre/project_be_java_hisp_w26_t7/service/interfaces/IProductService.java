package com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.LocationForProductDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.ProductResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.warehouse.StockQuantityResponseDto;

import java.util.List;

public interface IProductService {
    List<ProductResponseDTO> getProducts(String category);

    StockQuantityResponseDto findStockQuantityForEachWarehouse(Long idProduct);

    LocationForProductDTO checkLocationForProduct(Long idProduct, String order);
}
