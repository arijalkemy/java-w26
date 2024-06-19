package com.mercadolibre.fresh_market.service;

import com.mercadolibre.fresh_market.dtos.OperationResponseDTO;
import com.mercadolibre.fresh_market.dtos.ProductDetailDTO;
import com.mercadolibre.fresh_market.dtos.ProductStockDTO;

import java.util.List;

public interface IProductService {
    ProductStockDTO getProductStock(Long productId);
    List<ProductDetailDTO> getAllProducts();
    List<ProductDetailDTO> getAllProductsByCategory(String category);
    OperationResponseDTO createProduct (List<ProductDetailDTO> productsDTO, Long idSeller);
    OperationResponseDTO updateProduct(Long idSeller, Long idProduct, ProductDetailDTO productDetailDTO);
}
