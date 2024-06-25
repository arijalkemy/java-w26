package com.mercadolibre.project_be_java_hisp_w26_team4.service;

import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.WarehouseProductQuantityDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.WarehouseProductStockDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.ProductDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.exceptions.InvalidCategoryException;
import com.mercadolibre.project_be_java_hisp_w26_team4.exceptions.ProductNotFoundException;
import com.mercadolibre.project_be_java_hisp_w26_team4.model.ProductType;
import com.mercadolibre.project_be_java_hisp_w26_team4.model.ProductTypeEnum;
import com.mercadolibre.project_be_java_hisp_w26_team4.repository.IProductRepository;
import com.mercadolibre.project_be_java_hisp_w26_team4.repository.IProductTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;
    private final IProductTypeRepository productTypeRepository;

    @Override
    public WarehouseProductStockDTO searchProductStockInWarehouses(Long productId) {
        List<Object[]> results = productRepository.findProductQuantityInWarehouses(productId);
        List<WarehouseProductQuantityDTO> warehouseProductQuantity = results.stream()
                .map(result -> WarehouseProductQuantityDTO.builder()
                        .id(((Number) result[0]).longValue())
                        .totalQuantity(((Number) result[1]).intValue())
                        .build()).toList();

        if (warehouseProductQuantity.isEmpty()) {
            throw new ProductNotFoundException("Product not found");
        }

        return WarehouseProductStockDTO.builder()
                .productId(productId)
                .warehouseProductQuantity(warehouseProductQuantity)
                .build();
    }

    //Y que el producto tenga stock
    //
    //Y que el vencimiento del producto no sea inferior a 3 semanas

    /**
     * Search all products list.
     *
     * @param category the category
     * @return the list
     */
    @Override
    public List<ProductDTO> searchAllProducts(String category) {
        List<ProductDTO> productDTOList;
        ProductType productType;

        if(category != null){
            productType = switch (category) {
                case "FS" -> productTypeRepository.findByDescription(ProductTypeEnum.FRESCO);
                case "RF" -> productTypeRepository.findByDescription(ProductTypeEnum.REFRIGERADO);
                case "FF" -> productTypeRepository.findByDescription(ProductTypeEnum.CONGELADO);
                default -> throw new InvalidCategoryException("Invalid category");

            };

            try {
                productDTOList = productRepository.findAllByProductTypeId(productType.getId())
                        .stream().map(product -> ProductDTO.builder()
                                .id(product.getId())
                                .productType(product.getProductType())
                                .description(product.getDescription())
                                .price(product.getPrice())
                                .build()).toList();
            } catch (ProductNotFoundException ex){
                throw new ProductNotFoundException("The list is empty.");
            }

        } else {
            try {
                productDTOList = productRepository.findAll()
                        .stream()
                        .map(product -> ProductDTO.builder()
                                .id(product.getId())
                                .productType(product.getProductType())
                                .description(product.getDescription())
                                .price(product.getPrice())
                                .build()).toList();

            } catch (ProductNotFoundException ex){
                throw new ProductNotFoundException("The list is empty.");
            }
        }
        return productDTOList;
    }
}
