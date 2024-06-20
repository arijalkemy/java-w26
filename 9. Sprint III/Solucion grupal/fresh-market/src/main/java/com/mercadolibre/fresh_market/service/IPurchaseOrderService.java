package com.mercadolibre.fresh_market.service;



import org.springframework.security.core.userdetails.UserDetails;

import com.mercadolibre.fresh_market.dtos.ProjectionPurchaseOrder;
import com.mercadolibre.fresh_market.dtos.PurchaseOrderDTO;
import com.mercadolibre.fresh_market.dtos.Response;
import com.mercadolibre.fresh_market.dtos.ResponseDTO;

public interface IPurchaseOrderService {

    ResponseDTO modifyOrderExistence(Long orderId, PurchaseOrderDTO purchaseOrderDTO);
    Response createPurcharseOrder(PurchaseOrderDTO purchaseOrderDTO, UserDetails userDetails);
    ProjectionPurchaseOrder getProductsByPurchaseOrder(Long idOrder);
}
