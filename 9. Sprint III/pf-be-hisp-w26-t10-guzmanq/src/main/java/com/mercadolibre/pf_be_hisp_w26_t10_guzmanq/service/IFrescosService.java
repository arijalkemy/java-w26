package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.service;

import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos.ProductDto;

import java.util.Set;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos.PurchaseOrderDto;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos.PurchaseValueResponseDto;

public interface IFrescosService {
    public PurchaseValueResponseDto createOrder(PurchaseOrderDto order);
    public Set<ProductDto> getProductsFromShoppingCart(Integer id);
}
