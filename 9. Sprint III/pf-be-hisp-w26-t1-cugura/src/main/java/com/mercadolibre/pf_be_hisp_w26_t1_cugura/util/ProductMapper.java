package com.mercadolibre.pf_be_hisp_w26_t1_cugura.util;

import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.ProductDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.ProductPurchaseDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.ProductPurchaseResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.entity.Product;

public class ProductMapper {

    public static ProductResponseDTO toProductDto(Product product) {
        return ProductResponseDTO.builder()
                .name(product.getName())
                .price(product.getPrice())
                .category(product.getCategory().getName())
                .build();
    }

    public static Product productMappingFromProductPurchaseDto(ProductPurchaseDTO dto){
        return Product
                .builder()
                .id(dto.getProduct_id())
                .build();
    }

    public static ProductPurchaseResponseDto productPurchaseResponseDtoMappingFromProduct(Product product,Integer quantity){
        return ProductPurchaseResponseDto
                .builder()
                .name(product.getName())
                .quantity(quantity)
                .build();
    }

    public static Product productMappingFromProductDto(ProductDTO dto,Category category){
        return Product.builder()
            .category(category)
            .name(dto.getName())
            .price(dto.getPrice())
            .build();
    }

    public static void updateProduct(Product old,ProductDTO productDTO,Category category){
        old.setCategory(category);
        old.setName(productDTO.getName());
        old.setPrice(productDTO.getPrice());
    }
}
