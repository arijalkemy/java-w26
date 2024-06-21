package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.product.ListProductRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.product.LocationForProductDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.product.ProductCreateResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.product.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.warehouse.StockQuantityResponseDto;

import java.util.List;

public interface IProductService {
    List<ProductResponseDTO> getProducts(String category);

    StockQuantityResponseDto findStockQuantityForEachWarehouse(Long idProduct);

    LocationForProductDTO checkLocationForProduct(Long idProduct, String order);

    ProductCreateResponseDto createProduct(Long sellerId, ListProductRequestDto products);

    ProductCreateResponseDto updateProduct(Long sellerId, ListProductRequestDto products);
}
