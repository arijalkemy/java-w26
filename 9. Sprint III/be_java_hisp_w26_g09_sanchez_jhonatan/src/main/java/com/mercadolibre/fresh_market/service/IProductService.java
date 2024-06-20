package com.mercadolibre.fresh_market.service;

import com.mercadolibre.fresh_market.dtos.product.ProductDetailDTO;
import com.mercadolibre.fresh_market.dtos.ProductStockDTO;
import com.mercadolibre.fresh_market.dtos.product.ProductReqDTO;
import com.mercadolibre.fresh_market.dtos.product.ProductResDTO;

import java.util.List;

public interface IProductService {
    ProductStockDTO getProductStock(Long productId);

    List<ProductDetailDTO> getAllProducts();

    List<ProductDetailDTO> getAllProductsByCategory(String category);

    ProductResDTO createProducts(ProductReqDTO productReqDTO, Long sellerId);

    ProductResDTO updateProduct(ProductDetailDTO productDetailDTO, Long sellerId, Long productId);

}
