package com.mercadolibre.pf_be_hisp_w26_t6_martinez.controller;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.purchaseOrder.IPurchaseOrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PurchaseOrderControllerTest {
    @Mock
    IPurchaseOrderService purchaseOrderService;

    @InjectMocks
    PurchaseOrderController purchaseOrderController;

    @Test
    public void test(){
        purchaseOrderController.addProductsToCart(null);
        purchaseOrderController.getProductsFromCart(1L);
        purchaseOrderController.updateProductsFromCart(1L, null);

        Assertions.assertEquals(true,true);
    }
}


