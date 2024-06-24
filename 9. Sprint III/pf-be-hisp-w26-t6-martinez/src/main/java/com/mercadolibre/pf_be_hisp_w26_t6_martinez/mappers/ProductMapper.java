package com.mercadolibre.pf_be_hisp_w26_t6_martinez.mappers;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.ProductDto.ProductDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.ProductDto.ProductsResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.WarehouseDto.ProductByWarehouseDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.WarehouseDto.WarehouseQuantityDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.Product;

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
