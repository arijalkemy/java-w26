package com.mercadolibre.final_project_java_h_w26_t10.service;

import com.mercadolibre.final_project_java_h_w26_t10.dtos.ProductDto;

import java.util.Set;
import com.mercadolibre.final_project_java_h_w26_t10.dtos.PurchaseOrderDto;
import com.mercadolibre.final_project_java_h_w26_t10.dtos.PurchaseValueResponseDto;

public interface IFrescosService {
    public PurchaseValueResponseDto createOrder(PurchaseOrderDto order);
    public Set<ProductDto> getProductsFromShoppingCart(Integer id);
}
