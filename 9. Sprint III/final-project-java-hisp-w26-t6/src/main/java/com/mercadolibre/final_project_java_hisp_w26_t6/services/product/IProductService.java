package com.mercadolibre.final_project_java_hisp_w26_t6.services.product;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.ProductDto.ProductsResponseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.SectionDto.ListProductsBatchDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.WarehouseDto.ProductByWarehouseDto;

public interface IProductService {

    ProductsResponseDto getAllProductsByCategory(String category);

    ProductByWarehouseDto getTotalStockByProduct(Long id);

    ListProductsBatchDto listBatchsByProductId(Long productId, String username, String order);

}
