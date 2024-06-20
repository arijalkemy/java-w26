package com.mercadolibre.project_be_java_hisp_w26_t7.mapper;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.batch.BSResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.LocationForProductDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.ProductResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.projection.IBatchSectionProductProjection;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.projection.IProductResponseProjection;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.warehouse.SectionResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.ProductUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductResponseDTO mapToProductResponseDto(IProductResponseProjection product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .description(product.getDescription())
                .price(BigDecimal.valueOf(product.getPrice()))
                .sellerName(product.getSellerName())
                .category(product.getCategory())
                .build();
    }

    public static List<ProductResponseDTO> mapList(List<IProductResponseProjection> products) {
        return products.stream().map(ProductMapper::mapToProductResponseDto).toList();
    }

    public static LocationForProductDTO mapLocationForProductDTO(List<IBatchSectionProductProjection> projections, String order) {
        LocationForProductDTO locationForProduct = new LocationForProductDTO();
        locationForProduct.setSection(mapSectionResponseDTO(projections, order));
        locationForProduct.setProductId(projections.get(0).getProductId());
        locationForProduct.setBatchStock(mapListBSResponseDTO(projections, order));
        return locationForProduct;
    }

    public static SectionResponseDTO mapSectionResponseDTO(List<IBatchSectionProductProjection> projections, String order) {
        SectionResponseDTO section = new SectionResponseDTO();
        section.setSectionCode(Math.toIntExact(projections.get(0).getSectionCode()));
        section.setWarehouseCode(Math.toIntExact(projections.get(0).getWarehouseCode()));
        return section;
    }

    public static List<BSResponseDTO> mapListBSResponseDTO(List<IBatchSectionProductProjection> projections, String order) {
        List<BSResponseDTO> batchStock = projections.stream().map(response -> {
            BSResponseDTO bsResponse = new BSResponseDTO();
            bsResponse.setId(response.getBatchNumber());
            bsResponse.setCurrentQuantity(response.getCurrentQuantity());
            bsResponse.setDueDate(response.getDueDate());
            return bsResponse;
        }).collect(Collectors.toList());
        batchStock = ProductUtil.getProductBatchByOrder(batchStock, order);
        return batchStock;
    }
}
