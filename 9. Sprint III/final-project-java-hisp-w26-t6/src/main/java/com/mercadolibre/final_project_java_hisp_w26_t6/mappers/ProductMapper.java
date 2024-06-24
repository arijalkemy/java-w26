package com.mercadolibre.final_project_java_hisp_w26_t6.mappers;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.ProductDto.ProductDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.ProductDto.ProductsResponseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.WarehouseDto.ProductByWarehouseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.WarehouseDto.WarehouseQuantityDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Product;

import java.util.List;

public class ProductMapper {

    public static ProductByWarehouseDto createProductByWarehouseDto(
            Long productId, List<WarehouseQuantityDto> warehousesStocks){

        return ProductByWarehouseDto.builder()
                .productId(productId)
                .warehouses(warehousesStocks)
                .build();
    }

    public static ProductDto mapProductToDto(Product p) {
        return ProductDto.builder()
                .id(p.getId())
                .name(p.getName())
                .price(p.getUnitPrice())
                .category(p.getStorageType())
                .build();
    }

    public static ProductsResponseDto mapProductDtoListToResponseDto(List<ProductDto> products) {
        return ProductsResponseDto.builder()
                .products(products)
                .build();
    }
}
