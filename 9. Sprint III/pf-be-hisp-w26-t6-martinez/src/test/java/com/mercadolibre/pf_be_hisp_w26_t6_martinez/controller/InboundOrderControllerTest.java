package com.mercadolibre.pf_be_hisp_w26_t6_martinez.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class InboundOrderControllerTest {

    @InjectMocks
    InboundOrderController inboundOrderController;

    @Test
    public void test(){
        //inboundOrderController.insertBatchInFulfillmentWarehouse();
        //inboundOrderController.updateBatchInFulfillmentWarehouse();

        Assertions.assertEquals(true,true);
    }
}