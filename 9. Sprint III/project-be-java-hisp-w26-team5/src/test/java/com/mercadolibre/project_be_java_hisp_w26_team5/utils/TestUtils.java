package com.mercadolibre.project_be_java_hisp_w26_team5.utils;

import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.OrderStatusRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.ProductRequestPurchaseOrderDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.PurchaseOrderDataRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.PurchaseOrderRequestDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TestUtils {
    public static PurchaseOrderRequestDTO getPurchaseOrderRequestDTO(
            Integer userId, List<ProductRequestPurchaseOrderDTO> products
    ) {
        OrderStatusRequestDTO orderStatus = new OrderStatusRequestDTO();
        orderStatus.setStatusCode("shopping_cart");

        PurchaseOrderDataRequestDTO purchaseOrderData = new PurchaseOrderDataRequestDTO();
        purchaseOrderData.setDate(LocalDate.parse(
                "14-06-2024",
                DateTimeFormatter.ofPattern("dd-MM-yyyy")
        ));
        purchaseOrderData.setBuyerId(userId);
        purchaseOrderData.setOrderStatus(orderStatus);
        purchaseOrderData.setProducts(products);

        PurchaseOrderRequestDTO purchaseOrderRequest = new PurchaseOrderRequestDTO();
        purchaseOrderRequest.setPurchaseOrder(purchaseOrderData);
        return purchaseOrderRequest;
    }
}
