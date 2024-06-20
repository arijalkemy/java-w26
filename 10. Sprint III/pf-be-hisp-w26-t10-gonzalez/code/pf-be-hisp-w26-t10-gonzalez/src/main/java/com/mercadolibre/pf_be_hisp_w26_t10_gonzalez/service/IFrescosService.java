package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.service;

import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.ProductDto;

import java.util.Set;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.PurchaseOrderDto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.PurchaseValueResponseDto;

public interface IFrescosService {
    public PurchaseValueResponseDto createOrder(PurchaseOrderDto order);
    public Set<ProductDto> getProductsFromShoppingCart(Integer id);
}
