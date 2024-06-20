package com.mercadolibre.fresh_market.service;

import java.util.List;

import com.mercadolibre.fresh_market.dtos.product.ProductDTO;
import com.mercadolibre.fresh_market.model.Product;

public interface IPurchaseOrderValidationService {
   public List<Product> validateExistenceProducts(List<ProductDTO> listProductsToValidate);
   public Double validateStock(List<Product> products, List<ProductDTO> productsToValidate);
}
