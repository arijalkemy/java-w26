package com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.product;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.ProductDto.ProductsResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.SectionDto.ListProductsBatchDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.WarehouseDto.ProductByWarehouseDto;

public interface IProductService {

    ProductsResponseDto getAllProductsByCategory(String category);

    ProductByWarehouseDto getTotalStockByProduct(Long id);

    ListProductsBatchDto listBatchsByProductId(Long productId, String username, String order);

}
