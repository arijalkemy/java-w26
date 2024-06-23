package com.mercadolibre.project_be_java_hisp_w26_team5.service.interfaces;

import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.ProductDetailResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.ProductLocationByIdDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.ProductStockResponseDTO;

import java.util.List;

public interface IProductService {
    List<ProductDetailResponseDto> getProducts();
    ProductStockResponseDTO getTotalStockOfWarehouses(int idProduct);
    ProductLocationByIdDTO getProductLocationById(Integer productId,
                                                  Integer sellerId,
                                                  String order);
    List<ProductDetailResponseDto> getProductsByCategory(List<String> category);
}
