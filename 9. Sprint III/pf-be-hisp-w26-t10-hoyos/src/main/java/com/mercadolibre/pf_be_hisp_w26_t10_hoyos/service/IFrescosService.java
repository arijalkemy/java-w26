package com.mercadolibre.pf_be_hisp_w26_t10_hoyos.service;


import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos.ProductDto;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos.PurchaseOrderDto;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos.PurchaseValueResponseDto;

import java.util.Set;

public interface IFrescosService {
    public PurchaseValueResponseDto createOrder(PurchaseOrderDto order);
    public Set<ProductDto> getProductsFromShoppingCart(Integer id);
}
