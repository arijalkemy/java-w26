package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.ProductDetailResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.ProductLocationByIdDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.ProductStockResponseDTO;

import java.util.List;

public interface IProductService {
    List<ProductDetailResponseDto> getProducts();
    ProductStockResponseDTO getTotalStockOfWarehouses(int idProduct);
    ProductLocationByIdDTO getProductLocationById(Integer productId,
                                                  Integer sellerId,
                                                  String order);
    List<ProductDetailResponseDto> getProductsByCategory(List<String> category);
}
